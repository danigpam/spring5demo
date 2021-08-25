package com.danigpam.spring5demo.repository;

import com.danigpam.spring5demo.domain.Publisher;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    
}
