package com.stepit.lecture.genericshop.address.mapper;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;

public class AddressRequestMapper {

    public static Address mapAddressRequestToAddress(CreateAddressRequest createAddressRequest) {
        return Address.builder()
                .city(createAddressRequest.getCity())
                .street(createAddressRequest.getStreet())
                .street_num(createAddressRequest.getStreet_num())
                .build();
    }

    public static CreateAddressRequest mapAddressToAddressRequest(Address address) {
        return CreateAddressRequest.builder()
                .city(address.getCity())
                .street(address.getStreet())
                .street_num(address.getStreet_num())
                .build();
    }

}
