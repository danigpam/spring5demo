package com.danigpam.spring5demo.repository;

import com.danigpam.spring5demo.domain.Address;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
    
}
