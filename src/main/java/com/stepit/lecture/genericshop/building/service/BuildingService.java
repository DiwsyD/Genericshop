package com.stepit.lecture.genericshop.building.service;

import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.persistence.BuildingRepository;
import com.stepit.lecture.genericshop.building.request.CreateBuildingRequest;
import com.stepit.lecture.genericshop.building.request.DeleteBuildingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public Building getBuilding(Integer id) {
        log.info("Building Service Invoked");
        Optional<Building> building = buildingRepository.findById(id);
        return building.orElseGet(() -> Building.builder().build());
    }

    public Building createBuilding(
            CreateBuildingRequest createBuildingRequest
    ) {
        Building newBuilding = Building.builder()
//                .id(4)
                .price(createBuildingRequest.getPrice())
                .square(createBuildingRequest.getSquare())
                .address(
                        null
                ).build();
        return buildingRepository.save(newBuilding);
    }


    public void deleteBuildingByRequest(DeleteBuildingRequest deleteBuildingRequest) {
        buildingRepository.deleteById(deleteBuildingRequest.getId());
    }
}
