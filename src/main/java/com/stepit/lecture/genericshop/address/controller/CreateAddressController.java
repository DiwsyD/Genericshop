package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;
import com.stepit.lecture.genericshop.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @SuppressWarnings("unused")
    @PostMapping("${app.api.path.address.createAddress}")
    public ResponseEntity<AddressDto> createAddress(
            @RequestBody @Validated CreateAddressRequest createAddressRequest
    ) {
        AddressDto address = addressService.createAddress(createAddressRequest);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
