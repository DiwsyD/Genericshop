package com.stepit.lecture.genericshop.building.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBuildingRequest {

    private Integer id;

}
