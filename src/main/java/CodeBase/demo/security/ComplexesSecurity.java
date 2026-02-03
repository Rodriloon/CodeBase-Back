package CodeBase.demo.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

//Aca se especifican cuales endpoints de ComplexesControllers son públicos
public class ComplexesSecurity {

    public static void configure(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>
                    .AuthorizationManagerRequestMatcherRegistry auth
    ) {
        auth
                // privados
                .requestMatchers(HttpMethod.GET, "/api/v1/complexes/me").authenticated()
                // públicos, debe ir después de /me
                .requestMatchers(HttpMethod.GET, "/api/v1/complexes/*").permitAll();

    }
}

