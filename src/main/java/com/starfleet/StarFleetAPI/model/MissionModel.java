package com.starfleet.StarFleetAPI.model;

import com.starfleet.StarFleetAPI.model.dto.MissionDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "missions")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mission_id;

    private String name;
    private String goal;  //CHANGE TYPE IN DB
    private String status; // 'PLANNED', 'IN PROGRESS', 'COMPLETED', 'FAIL'
    private LocalDate start_date;
    private LocalDate end_date;
    private Long starship_id;

    public MissionModel() {}

    public MissionModel(MissionDto dto) {
        name = dto.name();
        goal = dto.goal();
        status = dto.status();
        start_date = dto.start_date();
        end_date = dto.end_date();
        starship_id = dto.starship_id();
    }

    public Long getMission_id() {
        return mission_id;
    }

//    public void setMission_id(Long mission_id) {
//        this.mission_id = mission_id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Long getStarship_id() {
        return starship_id;
    }

    public void setStarship_id(Long starship_id) {
        this.starship_id = starship_id;
    }
}
