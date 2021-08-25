package com.danigpam.spring5demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="publisher_sequence")
    @SequenceGenerator(name="publisher_sequence", sequenceName="publisher_sequence")
    @EqualsAndHashCode.Include
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name ="address_id")
    private Address address;
    
    @OneToMany
    @JoinColumn(name = "publisher_id")
    @Builder.Default
    private Set<Book> books = new HashSet<>();
}
