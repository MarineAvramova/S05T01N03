package cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.controllers;

import cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.domain.Flower;
import cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.achinian.mar.s05.t01.n03.S05T01N03AchinianMar.model.services.WebClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Tag(name = "Flower", description = "Flower management APIs")
@RestController
@RequestMapping("/flower")
public class FlowerController {

    @Autowired
    private  WebClientService webClientService;

    @Operation(summary = "This method is creating a new flower.",
            description = "Add a Flower object. The response is Flower object with id, name, " +
                    "country name and FlowerType(This property, depending on the country of origin of the flower, " +
                    "must indicate whether it is \"EU\" or \"Non-EU\".).")
    @PostMapping("/add")
    public Mono<ResponseEntity<FlowerDTO>> addFlower(@RequestBody Flower flower) {
        return webClientService.add(flower)
                .map(newFlower -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(newFlower));

    }
    @Operation(summary = "This method is updating existing flower.")
    @PutMapping("/update")
    public Mono<ResponseEntity<FlowerDTO>> updateFlower( @RequestBody FlowerDTO flowerDTO) {
        return webClientService.update(flowerDTO)
                .map(ResponseEntity::ok);
    }

    @Operation(summary = "This method is deleting an existing flower.")
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteFlower(@PathVariable("id") Integer id) {
        return webClientService.getOne(id)
                .flatMap(flower -> webClientService.delete(id)
                        .then(Mono.just(new ResponseEntity<>("Flower successfully deleted!", HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>("Flower not found!", HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "This method is showing flower by id",
            description = "Get a Flower object by specifying its id. The response is Flower object with id, name of flower, country of flower and type of country(\"EU\" or \"Non-EU\").",
            tags = { "flowers", "getOne" })
    @GetMapping("/getOne/{id}")
    public Mono<ResponseEntity<FlowerDTO>> getFlowerById(@PathVariable Integer id) {
        return webClientService.getOne(id)
                .map(flower -> ResponseEntity.ok(flower))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @Operation(summary = "This method is showing all flower.",
            description = "Get All Flower objects. The response is All Flower objects with id, name of flower, country of flower and type of country(\"EU\" or \"Non-EU\").",
            tags = { "flowers", "getAll" })
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllFlowers() {
        List<FlowerDTO> flowers =  webClientService.getAll();
        return ResponseEntity.ok().body(flowers);
    }
}
