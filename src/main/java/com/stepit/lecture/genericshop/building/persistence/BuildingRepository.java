package com.stepit.lecture.genericshop.building.persistence;

import com.stepit.lecture.genericshop.building.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
