package com.stepit.lecture.genericshop.building.service;

import com.stepit.lecture.genericshop.address.entity.Address;
import com.stepit.lecture.genericshop.address.mapper.AddressRequestMapper;
import com.stepit.lecture.genericshop.address.service.AddressService;
import com.stepit.lecture.genericshop.building.dto.BuildingDto;
import com.stepit.lecture.genericshop.building.entity.Building;
import com.stepit.lecture.genericshop.building.mapper.BuildingDtoMapper;
import com.stepit.lecture.genericshop.building.mapper.BuildingRequestMapper;
import com.stepit.lecture.genericshop.building.persistence.BuildingRepository;
import com.stepit.lecture.genericshop.building.request.CreateBuildingRequest;
import com.stepit.lecture.genericshop.building.request.DeleteBuildingRequest;
import com.stepit.lecture.genericshop.building.request.UpdateBuildingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    private final AddressService addressService;

    private final BuildingRequestMapper buildingRequestMapper;
    private final BuildingDtoMapper buildingDtoMapper;

    /**
     * Do not consider this approach as a Correct and Only way
     * to make logic of creation new object with inner (join) object(s).
     * [This approach is for educational purposes only]
     *
     * @param createBuildingRequest - necessary data to create new building with New or existing address
     * @return BuildingDto - representation of building entity.
     */
    public BuildingDto createBuilding(CreateBuildingRequest createBuildingRequest) {
        Address address = AddressRequestMapper
                .mapAddressRequestToAddress(createBuildingRequest.getAddress());
        address = addressService.findExisting(address);
        Building newBuilding =
                buildingRequestMapper.mapCreateBuildingRequestToBuilding(createBuildingRequest, address);
        Building savedBuilding = buildingRepository.save(newBuilding);
        return buildingDtoMapper.mapBuildingToBuildingDto(savedBuilding);
    }

    public BuildingDto getBuilding(Integer id) {
        Building building = buildingRepository.findById(id)
                .orElseGet(() -> Building.builder().build());
        return buildingDtoMapper.mapBuildingToBuildingDto(building);
    }

    public List<BuildingDto> getAllBuildings() {
        List<Building> buildings = buildingRepository.findAll();
        return buildingDtoMapper.mapBuildingsToBuildingDtos(buildings);
    }

    public BuildingDto updateBuildingByRequest(UpdateBuildingRequest updateBuildingRequest) {
        Integer buildingId = updateBuildingRequest.getId();
        Optional<Building> optBuilding = buildingRepository.findById(buildingId);

        if (optBuilding.isEmpty())
            throw new InvalidParameterException(String.format("Couldn't find building by ID [%d]", buildingId));

        Building building = optBuilding.get();
        building.setPrice(updateBuildingRequest.getPrice());
        building.setSquare(updateBuildingRequest.getSquare());

        Building updatedBuilding = buildingRepository.save(building);
        return buildingDtoMapper.mapBuildingToBuildingDto(updatedBuilding);
    }

    public void deleteBuildingByRequest(DeleteBuildingRequest deleteBuildingRequest) {
        buildingRepository.deleteById(deleteBuildingRequest.getId());
    }

}
