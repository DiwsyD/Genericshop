package com.stepit.lecture.genericshop.address.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAddressRequest {

    private String city;
    private String street;
    private Double street_num;

}
