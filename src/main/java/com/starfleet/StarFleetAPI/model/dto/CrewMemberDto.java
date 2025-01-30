package com.starfleet.StarFleetAPI.model.dto;

public record CrewMemberDto(
        String name,
        String rank,
        String species,
        Integer age,
        Long starship_id,
        String photo_url,
        String role) {
}
