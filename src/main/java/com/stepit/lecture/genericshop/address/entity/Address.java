package com.stepit.lecture.genericshop.address.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "addresses")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "streen_num")
    private Double streetnum;

}
