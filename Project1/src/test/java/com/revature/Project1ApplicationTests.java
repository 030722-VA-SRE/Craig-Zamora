package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.models.Beer;
import com.revature.repositories.BeerRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.AuthService;
import com.revature.services.BeerService;
import com.revature.services.UserService;

@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
class Project1ApplicationTests {
//
//	private static BeerService bs;
//	private UserService us;
//	private AuthService as;
//
//
//
//	private BeerRepository br;
//	private UserRepository ur;
//
//	private static List<Beer> beers;
//
//	@BeforeAll
//	public static void setup() {
//
//		beers = new ArrayList<>();
//
//	}

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testGetAll() {
//		beers = br.findAll();
//		assertEquals(beers, bs.getAllBeers());
//	}

}
