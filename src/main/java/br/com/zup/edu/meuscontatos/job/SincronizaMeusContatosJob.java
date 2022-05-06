package br.com.zup.edu.meuscontatos.job;

import br.com.zup.edu.meuscontatos.clients.feign.MeusContatosFeignClient;
import br.com.zup.edu.meuscontatos.clients.webclient.MeusContatosWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SincronizaMeusContatosJob {

    @Autowired
    private MeusContatosWebClient webClient;
    @Autowired
    private MeusContatosFeignClient feignClient;

    @Scheduled(fixedDelay = 10_000, initialDelay = 5000)
    public void execute() {

        System.out.println("-----------------------------------");
        System.out.println("------------ WebClient ------------");
        System.out.println("-----------------------------------");
        webClient.lista()
                .stream().forEach(System.out::println);

        System.out.println("-----------------------------------");
        System.out.println("-------------- Feign --------------");
        System.out.println("-----------------------------------");
        feignClient.lista()
                .stream().forEach(System.out::println);
    }
}
