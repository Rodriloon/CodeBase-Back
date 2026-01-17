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
                .requestMatchers(HttpMethod.GET, "/api/v1/complexes/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/complexes/**").permitAll(); // TODO: este tiene que ser privado, borrar despues
    }
}

