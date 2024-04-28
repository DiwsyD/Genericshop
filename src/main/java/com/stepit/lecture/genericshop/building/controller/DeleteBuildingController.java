package com.stepit.lecture.genericshop.building.controller;

import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.request.DeleteBuildingRequest;
import com.stepit.lecture.genericshop.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class DeleteBuildingController {

    private final BuildingService buildingService;

    @DeleteMapping("${app.api.path.building.deleteBuilding}")
    public ResponseEntity deleteBuilding(
            @RequestBody DeleteBuildingRequest deleteBuildingRequest
    ) {
        System.out.println(deleteBuildingRequest);
        buildingService.deleteBuildingByRequest(deleteBuildingRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
