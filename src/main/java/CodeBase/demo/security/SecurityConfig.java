package CodeBase.demo.security;

import CodeBase.demo.security.jwt.JwtAuthFilter;
import CodeBase.demo.security.jwt.JwtUtils;
import CodeBase.demo.service.CustomOAuth2UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint((req, res, exAuth) ->
                                res.sendError(HttpServletResponse.SC_UNAUTHORIZED)
                        )
                )
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/", "/oauth2/**", "/login/**").permitAll();
                    ComplexesSecurity.configure(auth);
                    FieldSecurity.configure(auth);
                    auth.anyRequest().authenticated();
                })
                .oauth2Login(oauth -> oauth
                        .userInfoEndpoint(userInfo ->
                                userInfo.userService(customOAuth2UserService)
                        )
                        .successHandler((request, response, authentication) -> {

                            OAuth2User oauthUser =
                                    (OAuth2User) authentication.getPrincipal();

                            String email = oauthUser.getAttribute("email");
                            if (email == null) {
                                response.sendError(
                                        HttpServletResponse.SC_BAD_REQUEST,
                                        "No se pudo obtener el email de Google"
                                );
                                return;
                            }

                            String token = jwtUtils.generateToken(email);

                            response.sendRedirect(
                                    "http://localhost:5173?token=" + token
                            );
                        })
                );

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // CORS
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")
        );
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}