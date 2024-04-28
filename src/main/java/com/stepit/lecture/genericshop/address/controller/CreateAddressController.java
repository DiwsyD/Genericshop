package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;
import com.stepit.lecture.genericshop.address.service.AddressService;
import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.request.CreateBuildingRequest;
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
public class CreateAddressController {

    private final AddressService addressService;

    @PostMapping("${app.api.path.address.createAddress}")
    public ResponseEntity<Address> createBuilding(
            @RequestBody CreateAddressRequest createAddressRequest
    ) {
        Address address = addressService.addAddress(createAddressRequest);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
