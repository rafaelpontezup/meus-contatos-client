package br.com.zup.edu.meuscontatos.clients.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class MeusContatosWebClient {

    private WebClient webClient;
    private String meusContatosUri;

    public MeusContatosWebClient(WebClient.Builder webClientBuilder,
                                 @Value("${integrations.meus-contatos.uri}") String meusContatosUri) {
        this.webClient = webClientBuilder.build();
        this.meusContatosUri = meusContatosUri;
    }

    public List<ContatoResponse> lista() {

        List<ContatoResponse> contatos = webClient.get()
                .uri(meusContatosUri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ContatoResponse>>() {})
                .block();

        return contatos;
    }

}
