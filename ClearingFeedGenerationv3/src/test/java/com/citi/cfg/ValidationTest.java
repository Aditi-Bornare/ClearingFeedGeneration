package com.citi.cfg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.citi.cfg.bean.validation;

class ValidationTest {

	@Mock
	validation v;
	
	@BeforeAll
	void init() {
		v= new validation();
	}
	
	@Test
	void specialCharacterTest() {
		assertEquals(true, v.specialCharacter('@'));
		assertEquals(false, v.specialCharacter('a'));
	}
	
	@Test
	void checkNumericStringTest() {
		assertEquals(false, v.checkNumericString(""));
		assertEquals(true, v.checkNumericString("12345"));
	}

}
