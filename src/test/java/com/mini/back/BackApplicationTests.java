package com.mini.back;

import com.mini.back.model.BusinessCard;
import com.mini.back.repository.BusinessCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@DataJpaTest
@SpringBootTest
class BackApplicationTests {

	@Autowired
	BusinessCardRepository businessCardRepository;

	@BeforeEach
	public void setUp() {
		businessCardRepository.save(BusinessCard.builder()
				.id(1L)
				.email("john@gmail.com")
				.phoneNumber("01012345678")
				.name("John")
				.position("Owner")
				.build());
		System.out.println("Save Card-1");
		businessCardRepository.save(BusinessCard.builder()
				.id(2L)
				.email("Spidy@gmail.com")
				.phoneNumber("01012345678")
				.name("Tom")
				.position("Hero")
				.build());
		System.out.println("Save Card-2");
	}
	
	@Test
	public void selectTester() {
		businessCardRepository.findAll().forEach(businessCard -> {
			System.out.println("businessCard get = " + businessCard);
		});
	}

	@Test
	public void updateTester() {
		businessCardRepository.save(BusinessCard.builder()
				.id(1L)
				.position("CEO")
				.name("Jea Dragon")
				.phoneNumber("010-1111-1111")
				.email("samsungking@gmail.com")
				.build());
		businessCardRepository.flush();
		List<BusinessCard> cards = businessCardRepository.findAll();
		assertEquals(cards.get(0).getId(), 1L);
		assertEquals(cards.get(0).getPosition(), "CEO");
		assertEquals(cards.get(0).getName(), "Jea Dragon");
		assertEquals(cards.get(0).getPhoneNumber(), "010-1111-1111");
		assertEquals(cards.get(0).getEmail(), "samsungking@gmail.com");

//		businessCardRepository.findAll().forEach(businessCard -> {
//			System.out.println("businessCard update = " + businessCard);
//		});
	}

	@Test
	public void delTest(){
		businessCardRepository.delete(businessCardRepository.findById(1L).get());
		System.out.println("delete test");
		businessCardRepository.flush();
		List<BusinessCard> cards = businessCardRepository.findAll();
		assertEquals(cards.get(0).getId(), 2L);
		assertEquals(cards.get(0).getName(), "Tom");
		assertEquals(cards.get(0).getPosition(), "Hero");
		assertEquals(cards.get(0).getPhoneNumber(), "01012345678");
		assertEquals(cards.get(0).getEmail(), "Spidy@gmail.com");

		businessCardRepository.findAll().forEach(businessCard -> {
			System.out.println("businessCard update = " + businessCard);
		});
	}

}
