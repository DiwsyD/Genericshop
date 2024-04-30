package com.stepit.lecture.genericshop.building.mapper;

import com.stepit.lecture.genericshop.address.mapper.AddressDtoMapper;
import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.building.entity.Building;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BuildingDtoMapper {

    private final AddressDtoMapper addressDtoMapper;

    public BuildingDto mapBuildingToBuildingDto(Building building) {
        return BuildingDto.builder()
                .id(building.getId())
                .price(building.getPrice())
                .square(building.getSquare())
                .full_address(
                        addressDtoMapper.mapAddressToAddressDto(building.getAddress())
                )
                .build();
    }

    public List<BuildingDto> mapBuildingsToBuildingDtos(List<Building> buildings) {
        return buildings.stream()
                .map(this::mapBuildingToBuildingDto)
                .collect(Collectors.toList());
    }
}
