package br.com.zup.edu.meuscontatos.clients.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
    name = "meusContatos",
    url = "${integrations.feign.meus-contatos.baseUrl}",
    configuration = OAuth2FeignConfiguration.class
)
public interface MeusContatosFeignClient {

    @GetMapping("/api/contatos")
    public List<ContatoResponse> lista();

}
