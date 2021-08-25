package com.danigpam.spring5demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_sequence")
    @SequenceGenerator(name="address_sequence", sequenceName="address_sequence")
    @EqualsAndHashCode.Include
    private Long id;
    private String address;
    private String city;
    private String state;
    private Long zip;
}
