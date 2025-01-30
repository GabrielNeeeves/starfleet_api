package com.starfleet.StarFleetAPI.repository;

import com.starfleet.StarFleetAPI.model.StarshipModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarshipRepository extends JpaRepository<StarshipModel, Long> {
}
