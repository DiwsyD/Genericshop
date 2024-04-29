package com.stepit.lecture.genericshop.building.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingDto {

    private Double price;
    private Double square;
    private String full_address;

}
