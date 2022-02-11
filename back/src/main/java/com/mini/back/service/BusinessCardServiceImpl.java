package com.mini.back.service;

import com.mini.back.model.BusinessCard;
import com.mini.back.repository.BusinessCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BusinessCardServiceImpl implements BusinessCardService{

    private final BusinessCardRepository businessCardRepository;

    @Override
    public BusinessCard addCard(BusinessCard businessCard) {
        log.info("add new Card");
        BusinessCard card = new BusinessCard();
        card = businessCardRepository.save(BusinessCard.builder()
                .id(null)
                .position(businessCard.getPosition())
                .name(businessCard.getName())
                .phoneNumber(businessCard.getPhoneNumber())
                .email(businessCard.getEmail())
                .build()
        );
        return card;
    }

    @Override
    public BusinessCard editCard(BusinessCard businessCard) {
        log.info("edit Card by id : {}", businessCardRepository.findById(businessCard.getId()).get());
        BusinessCard card = new BusinessCard();
        card = BusinessCard.builder()
                .id(businessCard.getId())
                .position(businessCard.getPosition())
                .name(businessCard.getName())
                .phoneNumber(businessCard.getPhoneNumber())
                .email(businessCard.getEmail())
                .build();
        businessCardRepository.save(card);
        return card;
    }

    @Override
    public List<BusinessCard> getAllCard() {
        log.info("get all Cards");
        return businessCardRepository.findAll();
    }

    @Override
    public Optional<BusinessCard> getCardById(Long id) {
        log.info("get Card by id : {}", id);
        return Optional.ofNullable(businessCardRepository.findById(id).get());
    }

    @Override
    public void delCard(Long id) {
        log.info("delete Card by Id {}", id);
        businessCardRepository.deleteById(id);
    }
}
