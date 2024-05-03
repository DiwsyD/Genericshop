package com.stepit.lecture.genericshop.address.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAddressRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{3,20}$",
            message = "Field 'City' should be between 3 and 20 characters long and can contains only latin letters.")
    private String city;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]{3,20}$",
            message = "Field 'Street' should be between 3 and 20 characters long and can contains only latin letters.")
    private String street;
    @Positive
    @Max(value = 1000, message = "street num should be less than 1000")
    private Double streetnum;

}
