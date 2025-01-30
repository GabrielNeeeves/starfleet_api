package com.starfleet.StarFleetAPI.controller;

import com.starfleet.StarFleetAPI.model.CrewMemberModel;
import com.starfleet.StarFleetAPI.model.dto.CrewMemberDto;
import com.starfleet.StarFleetAPI.repository.CrewMemberRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crewmembers")
public class CrewMemberController {

    @Autowired
    private CrewMemberRepository repo;

    //GET
    @GetMapping
    public List<CrewMemberModel> getCrewMembers() {
        return repo.findAll();
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CrewMemberModel> getCrewById(@PathVariable Long id) {

        Optional<CrewMemberModel> memberOptional = repo.findById(id);

        if(memberOptional.isPresent()) {
            var memberCrew = memberOptional.get();
            return new ResponseEntity<>(memberCrew, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //POST
    @PostMapping
    public ResponseEntity postCrew(@RequestBody CrewMemberDto dto) {

        try {
            var crewMemberModel = new CrewMemberModel(dto);
            repo.save(crewMemberModel);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch(Exception e) {
            return new ResponseEntity<>("Fail in POST CrewMember"+e, HttpStatus.BAD_REQUEST);
        }


    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity putCrew(@PathVariable Long id, @RequestBody CrewMemberDto dto) {

        var crewMemberOptional = repo.findById(id);
        if(crewMemberOptional.isPresent()) {
            var crewMember = crewMemberOptional.get();
            crewMember.setName(dto.name());
            crewMember.setRank(dto.rank());
            crewMember.setSpecies(dto.species());
            crewMember.setAge(dto.age());
            crewMember.setStarship_id(dto.starship_id());
            crewMember.setPhoto_url(dto.photo_url());
            crewMember.setPhoto_url(dto.photo_url());

            repo.save(crewMember);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCrew(@PathVariable Long id) {

        var crewOptional = repo.findById(id);
        if(crewOptional.isPresent()) {
            repo.deleteById(crewOptional
                    .get()
                    .getStarship_id());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


}
