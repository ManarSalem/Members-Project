package com.example.content.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Address {

    private String city;
    @Id
    private Integer id;
//    @OneToOne(mappedBy = "address")
//    private DTMember member;
}
