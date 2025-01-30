package com.starfleet.StarFleetAPI.controller;

import com.starfleet.StarFleetAPI.model.StarshipModel;
import com.starfleet.StarFleetAPI.model.dto.StarshipDto;
import com.starfleet.StarFleetAPI.repository.StarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/starships")
public class StarshipController {

    @Autowired
    private StarshipRepository repo;

    //GET
    @GetMapping
    public List<StarshipModel> getStarship() {
        return repo.findAll();
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StarshipModel> getById(@PathVariable Long id) {

        Optional<StarshipModel> starshipModelOptional = repo.findById(id);
        if(starshipModelOptional.isPresent()) {
            return ResponseEntity.ok(starshipModelOptional.get());
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //POST
    @PostMapping
    public ResponseEntity postStarship(@RequestBody StarshipDto dto) {

        try {
            StarshipModel starshipModel = new StarshipModel(dto);
            repo.save(starshipModel);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity("Fail at creating starship "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity putStarship(@PathVariable Long id, @RequestBody StarshipDto dto) {

            var optUpdate = repo.findById(id);

            if(optUpdate.isPresent()) {
                StarshipModel starshipModel = optUpdate.get();
                starshipModel.setName(dto.name());
                starshipModel.setType(dto.type());
                starshipModel.setLaunch_year(dto.launch_year());
                starshipModel.setStatus(dto.status());
                starshipModel.setPhoto_url(dto.photo_url());

                repo.save(starshipModel);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStarship(@PathVariable Long id) {

        Optional<StarshipModel> starshipModelOptional = repo.findById(id);

        if(starshipModelOptional.isPresent()) {
            repo.deleteById(starshipModelOptional
                    .get()
                    .getStarship_id());

            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

}
