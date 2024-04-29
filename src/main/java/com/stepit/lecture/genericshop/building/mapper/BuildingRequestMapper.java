package com.stepit.lecture.genericshop.building.mapper;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.request.CreateBuildingRequest;
import org.springframework.stereotype.Component;

@Component
public class BuildingRequestMapper {

    public Building mapCreateBuildingRequestToBuilding(CreateBuildingRequest createBuildingRequest, Address address) {
        return Building.builder()
                .price(createBuildingRequest.getPrice())
                .square(createBuildingRequest.getSquare())
                .address(
                        address
                ).build();
    }

}
