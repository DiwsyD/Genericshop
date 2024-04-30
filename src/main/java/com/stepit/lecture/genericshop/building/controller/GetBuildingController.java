package com.stepit.lecture.genericshop.building.controller;

import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class GetBuildingController {

    private final BuildingService buildingService;

    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.building.getBuilding}")
    public ResponseEntity<BuildingDto> getBuilding(
            @RequestParam Integer id
    ) {
        BuildingDto build = buildingService.getBuilding(id);
        return new ResponseEntity<>(build, HttpStatus.OK);
    }

}
