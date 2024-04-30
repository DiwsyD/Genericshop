package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class GetAddressesController {

    private final AddressService addressService;

    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.address.getAddresses}")
    public ResponseEntity<List<AddressDto>> getAddresses() {
        List<AddressDto> address = addressService.getAllAddresses();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
