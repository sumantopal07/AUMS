package com.au.aums;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class AppTest {

	App a;
	static int x;

	@BeforeAll
	static void beforeAll() {
		System.out.println("Begining testing...");
		x = 1;
	}

	@BeforeEach
	void init() {
		a = new App();
		System.out.println("starting.." + x);

	}

	@AfterEach
	void cleanUp() {
		System.out.println("cleaningg up..." + x);
		x += 1;
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Ending testing...");
		x = 1;
	}

	@Nested
	class Add {
		@Test
		@DisplayName("Testing add positive method")
		void testAddPositive() {
			int expected = 2;
			int actual = a.add(1, 1);
			assertEquals(expected, actual,() -> "The add positive method should add 2 numbers");
		}

		@Test
		@DisplayName("Testing add negative method")
		void testAddNegative() {
			int expected = 2;
			int actual = a.add(-1, 3);
			assertEquals(expected, actual, () ->"The add negative method should add 2 numbers");
		}
	}

	@RepeatedTest(3)
	@DisplayName("Testing divide method")
	void divide() {
		assertThrows(ArithmeticException.class, () -> a.divide(1, 0),() -> "division by zero should throw");
	}

	@Test
	@DisplayName("assertAll")
	void addition() {
		assertAll(
				() -> assertEquals(4,a.add(2,2)),
				() -> assertEquals(3,a.add(1,2)),
				() -> assertEquals(1,a.add(1,0)),
				() -> assertEquals(3,a.add(1,2))
				);
	}

	@Test
	@Disabled
	@DisplayName("Test fail")
	void Failed() {
		fail("failed");
	}

}
 
//		Conditional Execution 
//@EnableOnOs(OS.LINUS)
//@EnableOnJre(JRRE.JAVA_11)
//@EnabledIf
//@EnabledIfSystemProperty
//@EnabledIfEnvironmentVariable

// 	Handling external Factors

/**
 * junit-jupiter-api: API for writing tests using Junit Jupiter
 * 
 * junit-jupiter-engine; Implementation of the TestEngine API for Junit Jupiter
 * 
 * junit-vintage-engine: A thin layer on top of Junit 4 to allow running vintage
 * tests
 */