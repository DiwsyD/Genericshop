package com.stepit.lecture.genericshop.building.controller;

import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.building.request.UpdateBuildingRequest;
import com.stepit.lecture.genericshop.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class UpdateBuildingController {

    private final BuildingService buildingService;

    @SuppressWarnings("unused")
    @PostMapping("${app.api.path.building.updateBuilding}")
    public ResponseEntity<BuildingDto> updateBuilding(
            @RequestBody UpdateBuildingRequest updateBuildingRequest
    ) {
        BuildingDto building = buildingService.updateBuildingByRequest(updateBuildingRequest);
        return new ResponseEntity<>(building, HttpStatus.OK);
    }

}
