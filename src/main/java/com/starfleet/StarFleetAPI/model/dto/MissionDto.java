package com.starfleet.StarFleetAPI.model.dto;

import java.time.LocalDate;

public record MissionDto(String name,
                         String goal,
                         String status, //'PLANNED', 'IN PROGRESS', 'COMPLETED', 'FAIL'
                         LocalDate start_date,
                         LocalDate end_date,
                         Long starship_id) {

}
