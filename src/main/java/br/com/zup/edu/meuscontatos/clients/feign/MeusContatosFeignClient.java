package br.com.zup.edu.meuscontatos.clients.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "meus-contatos", url = "${integrations.meus-contatos.baseUrl}")
public interface MeusContatosFeignClient {

    @GetMapping("/api/contatos")
    public List<ContatoResponse> lista();

}
