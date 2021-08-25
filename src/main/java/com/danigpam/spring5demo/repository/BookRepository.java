package com.danigpam.spring5demo.repository;

import com.danigpam.spring5demo.domain.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
