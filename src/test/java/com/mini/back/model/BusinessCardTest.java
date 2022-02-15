package com.mini.back.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BusinessCardTest {
    @BeforeEach
    public void setUp() {}

    @Test
    public void creation() {
        BusinessCard businessCard = new BusinessCard(1L, "CEO", "이재용", "010-9999-9999", "samsungking@gmail.com");
        assertEquals(businessCard.getId(), 1L);
        assertEquals(businessCard.getPosition(), "CEO");
        assertEquals(businessCard.getName(), "이재용");
        assertEquals(businessCard.getPhoneNumber(), "010-9999-9999");
        assertEquals(businessCard.getEmail(), "samsungking@gmail.com");
    }
}
