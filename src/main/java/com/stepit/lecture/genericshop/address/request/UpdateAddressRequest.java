package com.stepit.lecture.genericshop.address.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAddressRequest {

    private Integer id;
    private String city;
    private String street;
    private Double streetnum;

}
