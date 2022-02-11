package com.mini.back.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class BusinessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String position;
    private String name;
    private String phoneNumber;
    private String email;

    @Builder
    public BusinessCard(Long id, String position, String name, String phoneNumber, String email) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
