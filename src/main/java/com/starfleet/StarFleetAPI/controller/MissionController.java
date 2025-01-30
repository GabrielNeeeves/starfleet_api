package com.starfleet.StarFleetAPI.controller;

import com.starfleet.StarFleetAPI.model.MissionModel;
import com.starfleet.StarFleetAPI.model.dto.MissionDto;
import com.starfleet.StarFleetAPI.repository.MissionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    @Autowired
    private MissionRepository repo;

    //GET
    @GetMapping
    public List<MissionModel> getMissions() {
        return repo.findAll();
    }

    //GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<MissionModel> getMissionById(@PathVariable Long id) {

        var missionOptional = repo.findById(id);
        if(missionOptional.isPresent()) {

            return new ResponseEntity<>(missionOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //POST
    @PostMapping
    public ResponseEntity postMission(@RequestBody MissionDto dto) {

        try {
            repo.save(new MissionModel(dto));
            return new ResponseEntity(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity putMission(@PathVariable Long id, @RequestBody MissionDto dto) {

        var missionOptional = repo.findById(id);
        if(missionOptional.isPresent()) {
            var missionModel = missionOptional.get();
            missionModel.setName(dto.name());
            missionModel.setGoal(dto.goal());
            missionModel.setStatus(dto.status());
            missionModel.setStart_date(dto.start_date());
            missionModel.setEnd_date(dto.end_date());
            missionModel.setStarship_id(dto.starship_id());

            repo.save(missionModel);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMission(@PathVariable Long id) {

        var missionOptional = repo.findById(id);
        if(missionOptional.isPresent()) {
            repo.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
