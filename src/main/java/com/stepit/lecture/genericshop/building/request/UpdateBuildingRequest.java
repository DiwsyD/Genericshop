package com.stepit.lecture.genericshop.building.request;

import com.stepit.lecture.genericshop.address.request.CreateAddressRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateBuildingRequest {

    private Integer id;
    private Double price;
    private Double square;

}
