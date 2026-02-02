package CodeBase.demo.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

public class FieldSecurity {
    public static void configure(
            AuthorizeHttpRequestsConfigurer<HttpSecurity>
                    .AuthorizationManagerRequestMatcherRegistry auth
    ) {
        auth
                .requestMatchers(HttpMethod.GET, "/api/v1/fields/*").permitAll();

    }
}
