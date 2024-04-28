package com.stepit.lecture.genericshop.address.persistence;

import com.stepit.lecture.genericshop.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
