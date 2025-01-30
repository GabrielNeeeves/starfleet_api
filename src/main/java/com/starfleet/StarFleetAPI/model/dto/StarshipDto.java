package com.starfleet.StarFleetAPI.model.dto;

import jakarta.persistence.Column;

public record StarshipDto(String name, String type, Integer launch_year, String status, String photo_url) {

}
