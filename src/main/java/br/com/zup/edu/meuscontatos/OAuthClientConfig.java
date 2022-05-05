package br.com.zup.edu.meuscontatos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class OAuthClientConfig {

    /**
     * The DefaultOAuth2AuthorizedClientManager is designed to be used within the context of a HttpServletRequest.
     * When operating outside of a HttpServletRequest context, use AuthorizedClientServiceOAuth2AuthorizedClientManager
     * instead.
     *
     * A service application is a common use case for when to use an AuthorizedClientServiceOAuth2AuthorizedClientManager.
     * Service applications often run in the background, without any user interaction, and typically run under a system-level
     * account instead of a user account. An OAuth 2.0 Client configured with the client_credentials grant type can be
     * considered a type of service application.
     *
     * https://docs.spring.io/spring-security/site/docs/5.3.2.RELEASE/reference/html5/#oauth2Client-authorized-manager-provider
     */
    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
                                                                 OAuth2AuthorizedClientService clientService) {

        OAuth2AuthorizedClientProvider provider
                            = OAuth2AuthorizedClientProviderBuilder.builder()
                            .clientCredentials()
                            .build();

        AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, clientService);
        authorizedClientManager.setAuthorizedClientProvider(provider);

        return authorizedClientManager;
    }
}
