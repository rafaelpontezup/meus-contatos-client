package br.com.zup.edu.meuscontatos.clients.webclient;

import io.netty.handler.logging.LogLevel;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
public class WebClientConfig implements WebClientCustomizer {

    @Override
    public void customize(WebClient.Builder builder) {

        HttpClient httpClient = HttpClient
                .create()
                .wiretap("reactor.netty.http.client.HttpClient",
                        LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);

        builder.clientConnector(new ReactorClientHttpConnector(httpClient));
    }
}
