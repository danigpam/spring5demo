package com.danigpam.spring5demo.repository;

import com.danigpam.spring5demo.domain.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
