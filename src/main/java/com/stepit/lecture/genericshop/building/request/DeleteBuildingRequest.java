package com.stepit.lecture.genericshop.building.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeleteBuildingRequest {

    private Integer id;
    private String nothing;

}
