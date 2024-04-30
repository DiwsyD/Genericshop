package com.stepit.lecture.genericshop.address.mapper;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;

public class AddressRequestMapper {

    public static Address mapAddressRequestToAddress(CreateAddressRequest createAddressRequest) {
        return Address.builder()
                .city(createAddressRequest.getCity())
                .street(createAddressRequest.getStreet())
                .streetnum(createAddressRequest.getStreetnum())
                .build();
    }

}
