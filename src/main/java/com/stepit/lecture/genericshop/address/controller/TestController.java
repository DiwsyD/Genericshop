package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.persistence.AddressRepository;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;
import com.stepit.lecture.genericshop.address.service.AddressService;
import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.persistence.BuildingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class TestController {

    private final BuildingRepository buildingRepository;

    @GetMapping("/test")
    public ResponseEntity<List<Building>> getTest() {
        List<Building> cheapBuildings = buildingRepository.findCheapBuildings(200.0);

        return new ResponseEntity<>(cheapBuildings, HttpStatus.OK);
    }

}
