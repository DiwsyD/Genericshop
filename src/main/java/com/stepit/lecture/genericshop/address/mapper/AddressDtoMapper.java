package com.stepit.lecture.genericshop.address.mapper;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressDtoMapper {

    public AddressDto mapAddressToAddressDto(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .city(address.getCity())
                .street(address.getStreet() + " #" + address.getStreetnum())
                .build();
    }

    public List<AddressDto> mapAddressesToAddressDtos(List<Address> addresses) {
        return addresses.stream()
                .map(this::mapAddressToAddressDto)
                .collect(Collectors.toList());
    }
}
