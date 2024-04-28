package com.stepit.lecture.genericshop.building.entity;

import com.stepit.lecture.genericshop.address.entity.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "buildings")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "price")
    private Double price;
    @Column(name = "square")
    private Double square;
    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "addresses_id")
    private Address address;

}
