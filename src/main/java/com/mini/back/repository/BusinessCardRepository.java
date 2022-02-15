package com.mini.back.repository;

import com.mini.back.model.BusinessCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessCardRepository extends JpaRepository<BusinessCard, Long> {
}
