package com.stepit.lecture.genericshop.building.service;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.mapper.AddressRequestMapper;
import com.stepit.lecture.genericshop.address.service.AddressService;
import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.persistence.BuildingRepository;
import com.stepit.lecture.genericshop.building.request.CreateBuildingRequest;
import com.stepit.lecture.genericshop.building.request.DeleteBuildingRequest;
import com.stepit.lecture.genericshop.building.request.UpdateBuildingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final AddressService addressService;

    public Building getBuilding(Integer id) {
        log.info("Building Service Invoked");
        Optional<Building> building = buildingRepository.findById(id);
        return building.orElseGet(() -> Building.builder().build());
    }

    public Building createBuilding(
            CreateBuildingRequest createBuildingRequest
    ) {
        Address address = AddressRequestMapper
                .mapAddressRequestToAddress(createBuildingRequest.getAddress());
        address = addressService.findExisting(address);
        Building newBuilding = Building.builder()
                .price(createBuildingRequest.getPrice())
                .square(createBuildingRequest.getSquare())
                .address(
                        address
                ).build();
        return buildingRepository.save(newBuilding);
    }

    public void deleteBuildingByRequest(DeleteBuildingRequest deleteBuildingRequest) {
        buildingRepository.deleteById(deleteBuildingRequest.getId());
    }

    public Building updateBuildingByRequest(UpdateBuildingRequest updateBuildingRequest) {

        Building building = getBuilding(updateBuildingRequest.getId());
        building.setPrice(updateBuildingRequest.getPrice());
        building.setSquare(updateBuildingRequest.getSquare());

        return buildingRepository.save(building);
    }
}
