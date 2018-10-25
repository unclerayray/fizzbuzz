package com.roger.fizzbuzz;

import com.roger.fizzbuzz.controller.FizzBuzzController;
import com.roger.fizzbuzz.exception.InvalidFormatException;
import com.roger.fizzbuzz.exception.NumberOutOfRangeException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzControllerTests {
    private FizzBuzzController fizzBuzzController;
	@Autowired
	private MockMvc mvc;

	@Before
	public void setUp() {
		fizzBuzzController = new FizzBuzzController();
	}

	@Test
	public void fizzbuzz() throws Exception {
		this.mvc.perform(get("/fizzbuzz/10")).andExpect(status().isOk())
				.andExpect(content().string("1\n" +
						"2\n" +
						"Fizz\n" +
						"4\n" +
						"Buzz\n" +
						"Fizz\n" +
						"7\n" +
						"8\n" +
						"Fizz\n" +
						"Buzz\n"));
	}

	@Test
	public void fizzbuzzPlus() throws Exception {
		this.mvc.perform(get("/fizzbuzzplus/25")).andExpect(status().isOk())
				.andExpect(content().string("1\n" +
						"2\n" +
						"Fizz\n" +
						"4\n" +
						"Buzz\n" +
						"Fizz\n" +
						"7\n" +
						"8\n" +
						"Fizz\n" +
						"Buzz\n" +
						"11\n" +
						"Fizz\n" +
						"Fizz\n" +
						"14\n" +
						"FizzBuzz\n" +
						"16\n" +
						"17\n" +
						"Fizz\n" +
						"19\n" +
						"Buzz\n" +
						"Fizz\n" +
						"22\n" +
						"Fizz\n" +
						"Fizz\n" +
						"Buzz\n"));
	}

	@Test(expected = InvalidFormatException.class)
	public void validateAndParse() throws Exception {
		fizzBuzzController.validateAndParse("not A number");
	}

	@Test(expected = InvalidFormatException.class)
	public void validateAndParseEmptyString() throws Exception {
		fizzBuzzController.validateAndParse("");
	}

	@Test(expected = InvalidFormatException.class)
	public void validateAndParseNull() throws Exception {
		fizzBuzzController.validateAndParse(null);
	}

	@Test(expected = NumberOutOfRangeException.class)
	public void validateAndParseOutOfRangeSmall() throws Exception {
		fizzBuzzController.validateAndParse("0");
	}

	@Test(expected = NumberOutOfRangeException.class)
	public void validateAndParseOutOfRangeLarge() throws Exception {
		fizzBuzzController.validateAndParse("99999");
	}

	@Test(expected = NumberOutOfRangeException.class)
	public void validateAndParseOutOfRangeNegative() throws Exception {
		fizzBuzzController.validateAndParse("-19");
	}

}
