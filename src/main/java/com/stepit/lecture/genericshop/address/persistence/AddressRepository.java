package com.stepit.lecture.genericshop.address.persistence;

import com.stepit.lecture.genericshop.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findByCityAndStreetAndStreetnum(String city, String street, Double street_num);

    @Query("SELECT a FROM Address a WHERE a.city = :city AND NOT street = :street")
    List<Address> findByCityAndNotByStreet(String city, String street);

}
