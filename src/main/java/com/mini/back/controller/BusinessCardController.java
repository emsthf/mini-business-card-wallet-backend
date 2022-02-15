package com.mini.back.controller;

import com.mini.back.model.BusinessCard;
import com.mini.back.service.BusinessCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Log
public class BusinessCardController {

    private final BusinessCardService businessCardService;

    @PostMapping("/add")
    public void add(@RequestBody BusinessCard businessCard) {
        log.info("========================================>" + businessCard.getPosition());
        businessCardService.addCard(businessCard);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody BusinessCard businessCard) {
        businessCardService.editCard(businessCard);
    }

    @GetMapping("/getAll")
    public List<BusinessCard> getAll() {
        return businessCardService.getAllCard();
    }

    @GetMapping("/get/{id}")
    public BusinessCard get(@PathVariable("id") Long id) {
        return businessCardService.getCardById(id).get();
    }

    @DeleteMapping("/del/{id}")
    public void del(@PathVariable("id") Long id) {
        businessCardService.delCard(id);
    }
}
