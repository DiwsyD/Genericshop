package com.stepit.lecture.genericshop.address.controller;

import com.stepit.lecture.genericshop.address.request.DeleteAddressRequest;
import com.stepit.lecture.genericshop.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class DeleteAddressController {

    private final AddressService addressService;

    @SuppressWarnings("unused")
    @DeleteMapping("${app.api.path.address.deleteAddress}")
    public ResponseEntity<Void> deleteAddress(
            @RequestBody DeleteAddressRequest deleteAddressRequest
    ) {
        addressService.deleteAddress(deleteAddressRequest);
        return ResponseEntity.ok().build();
    }

}
