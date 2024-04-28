package com.stepit.lecture.genericshop.address.service;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.mapper.AddressRequestMapper;
import com.stepit.lecture.genericshop.address.persistence.AddressRepository;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Address addAddress(CreateAddressRequest createAddressRequest) {
        Address address = AddressRequestMapper.mapAddressRequestToAddress(createAddressRequest);
        return addressRepository.save(address);
    }

    public Address getAddress(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);
        return byId.orElseGet(() -> Address.builder().build());
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }

}
