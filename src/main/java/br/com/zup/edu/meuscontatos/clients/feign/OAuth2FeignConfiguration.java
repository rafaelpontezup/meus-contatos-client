package br.com.zup.edu.meuscontatos.clients.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

/**
 * Usar @Configuration faz os interceptors dessa classe GLOBAIS, o que pode ser perigoso
 * se sua aplicação se comunica com outros serviços via HTTP.
 *
 * https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html#spring-cloud-feign-overriding-defaults
 */
@Configuration
public class OAuth2FeignConfiguration {

    @Bean
    public OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor(OAuth2AuthorizedClientManager clientManager) {
        return new OAuth2FeignRequestInterceptor(clientManager, "meus-contatos");
    }

}