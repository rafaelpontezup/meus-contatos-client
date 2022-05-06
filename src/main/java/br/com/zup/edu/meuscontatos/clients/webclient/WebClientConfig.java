package br.com.zup.edu.meuscontatos.clients.webclient;

import io.netty.handler.logging.LogLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

import java.util.function.Consumer;

/**
 * https://docs.spring.io/spring-security/site/docs/5.3.2.RELEASE/reference/html5/#oauth2Client-webclient-servlet
 */
@Configuration
public class WebClientConfig implements WebClientCustomizer {

    @Autowired
    private OAuth2AuthorizedClientManager authorizedClientManager;

    @Override
    public void customize(WebClient.Builder builder) {
        builder
            .apply(oauth2Configuration())
            .clientConnector(clientHttpConnector()) // logging
        ;
    }

    private Consumer<WebClient.Builder> oauth2Configuration() {

        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2
                = new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth2.setDefaultClientRegistrationId("meus-contatos");
        return oauth2.oauth2Configuration();
    }

    private ReactorClientHttpConnector clientHttpConnector() {
        HttpClient httpClient = HttpClient
                .create()
                .wiretap("reactor.netty.http.client.HttpClient",
                        LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);

        return new ReactorClientHttpConnector(httpClient);
    }
}
