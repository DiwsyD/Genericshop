package com.stepit.lecture.genericshop.building.mapper;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.building.entity.Building;
import org.springframework.stereotype.Component;

@Component
public class BuildingDtoMapper {

    public BuildingDto mapBuildingToBuildingDto(Building building) {
        Address address = building.getAddress();
        return BuildingDto.builder()
                .price(building.getPrice())
                .square(building.getSquare())
                .full_address(
                        address.getCity() + ", " + address.getStreet() + " #" + address.getStreetnum()
                )
                .build();


    }

}
