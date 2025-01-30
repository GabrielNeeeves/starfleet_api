package com.starfleet.StarFleetAPI.model;

import com.starfleet.StarFleetAPI.model.dto.StarshipDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STARSHIPS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StarshipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long starship_id;

    private String name;

    @Column(name = "class")
    private String type;

    private Integer launch_year;
    private String status;
    private String photo_url;

    public StarshipModel(){}

    public StarshipModel(StarshipDto dto) {
        this.name = dto.name();
        this.type = dto.type();
        this.launch_year = dto.launch_year();
        this.status = dto.status();
        this.photo_url = dto.photo_url();
    }

    public Long getStarship_id() {
        return starship_id;
    }

//    public void setStarship_id(Long starship_id) {
//        this.starship_id = starship_id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(Integer launch_year) {
        this.launch_year = launch_year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
