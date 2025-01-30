package com.starfleet.StarFleetAPI.repository;

import com.starfleet.StarFleetAPI.model.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<MissionModel, Long> {
}
