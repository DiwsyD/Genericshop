package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.request.UpdateAddressRequest;
import com.stepit.lecture.genericshop.address.service.AddressService;
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
public class UpdateAddressController {

    private final AddressService addressService;

    @SuppressWarnings("unused")
    @PostMapping("${app.api.path.address.updateAddress}")
    public ResponseEntity<AddressDto> updateAddress(
            @RequestBody UpdateAddressRequest updateAddressRequest
    ) {
        AddressDto address = addressService.updateAddress(updateAddressRequest);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
