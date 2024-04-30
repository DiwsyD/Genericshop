package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.service.AddressService;
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
public class GetAddressController {

    private final AddressService addressService;

    @SuppressWarnings("unused")
    @GetMapping("${app.api.path.address.getAddress}")
    public ResponseEntity<AddressDto> getAddress(
            @RequestParam Integer id
    ) {
        AddressDto address = addressService.getAddress(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
