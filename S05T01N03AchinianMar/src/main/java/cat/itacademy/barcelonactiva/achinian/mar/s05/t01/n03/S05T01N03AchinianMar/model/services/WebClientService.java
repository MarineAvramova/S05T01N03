package cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.services;

import cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.config.WebClientConfig;
import cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.dto.FlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebClientService {

    @Autowired
    public WebClient webClient;

    public Mono <FlowerDTO> add(Flower flower){
        return webClient.post()
                .uri("/flower/add")
                .bodyValue(flower)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    public Mono<FlowerDTO> update(FlowerDTO flowerDTO) {
        return webClient.put()
                .uri("/flower/update", flowerDTO)
                .bodyValue(flowerDTO)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    public Mono<FlowerDTO> getOne(Integer id) {
        return webClient.get()
                .uri("/flower/getOne/{id}", id)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    public List<FlowerDTO> getAll(){
        return this.webClient.get()
                .uri("/flower/getAll")
                .retrieve()
                .bodyToFlux(FlowerDTO.class)
                .collectList().block();
    }



    public Mono<String>delete(Integer id){
        return  webClient.delete()
                .uri("/flower/delete/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}


