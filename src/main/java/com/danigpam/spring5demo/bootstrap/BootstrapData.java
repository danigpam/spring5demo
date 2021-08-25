package com.danigpam.spring5demo.bootstrap;

import com.danigpam.spring5demo.domain.Address;
import com.danigpam.spring5demo.domain.Author;
import com.danigpam.spring5demo.domain.Book;
import com.danigpam.spring5demo.domain.Publisher;
import com.danigpam.spring5demo.repository.AddressRepository;
import com.danigpam.spring5demo.repository.AuthorRepository;
import com.danigpam.spring5demo.repository.BookRepository;
import com.danigpam.spring5demo.repository.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        Address address = Address.builder().address("Latias st, 123").city("Veridian").state("Oak State").zip(987654L).build();
        Publisher publisher = Publisher.builder().name("Penguin").address(address).build();

        addressRepository.save(address);
        publisherRepository.save(publisher);

        Author erick = Author.builder().firstName("Erick").lastName("Jacquin").build();
        Book cookingBook = Book.builder().title("Cozinhando com tompero").isbn("1234").build();
        erick.getBooks().add(cookingBook);
        cookingBook.getAuthors().add(erick);
        cookingBook.setPublisher(publisher);

        authorRepository.save(erick);
        bookRepository.save(cookingBook);

        Author paola = Author.builder().firstName("Paola").lastName("Carosella").build();
        Book cookingBook2 = Book.builder().title("Culinaria francesa").isbn("4321").build();
        paola.getBooks().add(cookingBook2);
        cookingBook2.getAuthors().add(paola);

        authorRepository.save(paola);
        bookRepository.save(cookingBook2);
        cookingBook2.setPublisher(publisher);

        System.out.println("Starting with bootstrap");
        System.out.println("Number of books: " + bookRepository.count() );


        Iterable<Book> l = bookRepository.findAll();

        l.forEach(b -> {
            System.out.println(b.getId());
            System.out.println(b.getTitle());
            Publisher p = b.getPublisher();
            if (p!=null) { 
            System.out.println(p.getName());
            }
        });
    }
}
