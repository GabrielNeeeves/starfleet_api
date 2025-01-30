package com.starfleet.StarFleetAPI.repository;

import com.starfleet.StarFleetAPI.model.CrewMemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewMemberRepository extends JpaRepository<CrewMemberModel, Long> {
}
