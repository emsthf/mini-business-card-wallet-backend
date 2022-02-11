package com.mini.back.service;

import com.mini.back.model.BusinessCard;

import java.util.List;
import java.util.Optional;

public interface BusinessCardService {
    BusinessCard addCard(BusinessCard businessCard);
    BusinessCard editCard(BusinessCard businessCard);
    List<BusinessCard> getAllCard();
    Optional<BusinessCard> getCardById(Long id);
    void delCard(Long id);
}
