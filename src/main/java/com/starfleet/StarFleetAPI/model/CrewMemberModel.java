package com.starfleet.StarFleetAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CREW_MEMBERS")
public class CrewMemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String name;
    private String rank;
    private String species;
    private Integer age;
    private Long starship_id;
    private String photo_url;
    private String role;

    public CrewMemberModel(){}

    public Long getMember_id() {
        return member_id;
    }

//    public void setMember_id(Long member_id) {
//        this.member_id = member_id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getStarship_id() {
        return starship_id;
    }

    public void setStarship_id(Long starship_id) {
        this.starship_id = starship_id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
