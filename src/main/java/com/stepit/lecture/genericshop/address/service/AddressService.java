package com.stepit.lecture.genericshop.address.service;

import com.stepit.lecture.genericshop.address.dto.AddressDto;
import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.mapper.AddressDtoMapper;
import com.stepit.lecture.genericshop.address.mapper.AddressRequestMapper;
import com.stepit.lecture.genericshop.address.persistence.AddressRepository;
import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;
import com.stepit.lecture.genericshop.address.request.DeleteAddressRequest;
import com.stepit.lecture.genericshop.address.request.UpdateAddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    private final AddressDtoMapper addressDtoMapper;

    public AddressDto createAddress(CreateAddressRequest createAddressRequest) {
        Address newAddress = AddressRequestMapper.mapAddressRequestToAddress(createAddressRequest);
        return addressDtoMapper.mapAddressToAddressDto(addressRepository.save(newAddress));
    }

    public AddressDto getAddress(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);
        if (byId.isEmpty())
            throw new InvalidParameterException(String.format("Couldn't find address by ID [%d]", id));
        return addressDtoMapper.mapAddressToAddressDto(byId.get());
    }

    public Address findExisting(Address address) {
        Optional<Address> byCityAndStreetAndStreetnum = addressRepository
                .findByCityAndStreetAndStreetnum(address.getCity(), address.getStreet(), address.getStreetnum());
        return byCityAndStreetAndStreetnum.orElse(address);
    }

    public AddressDto updateAddress(UpdateAddressRequest updateAddressRequest) {
        Integer addressId = updateAddressRequest.getId();
        Optional<Address> optAddress = addressRepository.findById(addressId);

        if (optAddress.isEmpty())
            throw new InvalidParameterException(String.format("Couldn't find address by ID [%d]", addressId));

        Address address = optAddress.get();
        address.setCity(updateAddressRequest.getCity());
        address.setStreet(updateAddressRequest.getStreet());
        address.setStreetnum(updateAddressRequest.getStreetnum());

        Address updatedAddress = addressRepository.save(address);
        return addressDtoMapper.mapAddressToAddressDto(updatedAddress);
    }

    public void deleteAddress(DeleteAddressRequest deleteAddressRequest) {
        addressRepository.deleteById(deleteAddressRequest.getId());
    }

    public List<AddressDto> getAllAddresses() {
        return addressDtoMapper.mapAddressesToAddressDtos(addressRepository.findAll());
    }
}
