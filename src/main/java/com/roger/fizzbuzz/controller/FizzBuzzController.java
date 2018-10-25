package com.roger.fizzbuzz.controller;

import com.roger.fizzbuzz.exception.InvalidFormatException;
import com.roger.fizzbuzz.exception.NumberOutOfRangeException;
import com.roger.fizzbuzz.service.IFizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.regex.Pattern;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Configuration
public class FizzBuzzController extends SpringBootServletInitializer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final Pattern pattern = Pattern.compile("^-?\\d+$");
	private final String INVALID_MSG = "Invalid input! ";

	@Resource
	@Qualifier("fizzBuzzService")
	private IFizzBuzzService fizzBuzzService;

	@Resource
	@Qualifier("fizzBuzzPlusService")
	private IFizzBuzzService fizzBuzzPlusService;

	public static void main(String[] args) {
		SpringApplication.run(FizzBuzzController.class, args);
	}

	@RequestMapping(value = "/fizzbuzz/{number}", method=GET)
	public String playFizzBuzz(@PathVariable String number){
		try {
			int intNumber = validateAndParse(number);
			return output(intNumber, fizzBuzzService);
		} catch (InvalidFormatException e) {
			logger.info(e.getMessage());
			return e.getMessage();
		} catch (NumberOutOfRangeException e) {
			logger.info(e.getMessage());
			return e.getMessage();
		} catch (Exception e) {
			logger.info("oops, something funny just happened. " + e.getMessage());
			return "how...?";
		}
	}

	@RequestMapping(value = "/fizzbuzzplus/{number}", method=GET)
	public String playFizzBuzzPlus(@PathVariable String number){
		try {
			int intNumber = validateAndParse(number);
			return output(intNumber, fizzBuzzPlusService);
		} catch (InvalidFormatException e) {
			logger.info(e.getMessage());
			return e.getMessage();
		} catch (NumberOutOfRangeException e) {
			logger.info(e.getMessage());
			return e.getMessage();
		} catch (Exception e) {
			logger.info("oops, something unexpected just happened while doing fuzz buzz plus. " + e.getMessage());
			return "how...?";
		}
	}

	public int validateAndParse(String number) throws Exception{
		if(StringUtils.isEmpty(number)){
			throw new InvalidFormatException(INVALID_MSG + " It cannot be empty.");
		}else{
			if(pattern.matcher(number).find()){
				int intNumber = Integer.parseInt(number);
				if(intNumber > NumberOutOfRangeException.MAX_NUMBER || intNumber < NumberOutOfRangeException.MIN_NUMBER){
					throw new NumberOutOfRangeException(INVALID_MSG + " The input number can only be greater than 1 and less than 10000.");
				}
				return intNumber;
			}else{
				throw new InvalidFormatException(INVALID_MSG + " It can only be an integer.");
			}
		}
	}

	private String output(int input, IFizzBuzzService fizzBuzzService) throws RuntimeException{
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= input; i++) {
			sb.append(fizzBuzzService.fizzBuzz(i));
			//System.out.println(fizzBuzzService.fizzBuzz(i));
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}

}
