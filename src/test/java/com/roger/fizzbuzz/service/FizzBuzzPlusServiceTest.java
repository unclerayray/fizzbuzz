package com.roger.fizzbuzz.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzPlusServiceTest {

    private FizzBuzzPlusService fizzBuzzPlusService;

    @Before
    public void setUp() {
        fizzBuzzPlusService = new FizzBuzzPlusService();
    }

    @Test
    public void fizzBuzz() {
        //Assert.assertEquals("0",fizzBuzzPlusService.fizzBuzz(0)); not a valid test case since the input should be greater than 0
        Assert.assertEquals("1\n", fizzBuzzPlusService.fizzBuzz(1));
        Assert.assertEquals("Fizz\n", fizzBuzzPlusService.fizzBuzz(3));
        Assert.assertEquals("Buzz\n", fizzBuzzPlusService.fizzBuzz(5));
        Assert.assertEquals("Fizz\n", fizzBuzzPlusService.fizzBuzz(6));
        Assert.assertEquals("Buzz\n", fizzBuzzPlusService.fizzBuzz(10));
        Assert.assertEquals("Fizz\n", fizzBuzzPlusService.fizzBuzz(13));

        Assert.assertEquals("FizzBuzz\n", fizzBuzzPlusService.fizzBuzz(30));
        Assert.assertEquals("FizzBuzz\n", fizzBuzzPlusService.fizzBuzz(35));
        Assert.assertEquals("Buzz\n", fizzBuzzPlusService.fizzBuzz(100));
    }

    @Test
    public void isDigitPresent() {
        Assert.assertFalse(fizzBuzzPlusService.isDigitPresent(0,3));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(1,1));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(3,3));
        Assert.assertFalse(fizzBuzzPlusService.isDigitPresent(6,2));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(5,5));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(13,3));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(15,5));

        //2 digit
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(26,2));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(26,6));

        Assert.assertFalse(fizzBuzzPlusService.isDigitPresent(88,1));
        Assert.assertFalse(fizzBuzzPlusService.isDigitPresent(88,2));

        //3 digit
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(115,1));
        Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(115,5));
        Assert.assertFalse(fizzBuzzPlusService.isDigitPresent(115,3));
        Assert.assertFalse(fizzBuzzPlusService.isDigitPresent(115,6));


        //invalid test case, d can not be greater than 9
        //Assert.assertTrue(fizzBuzzPlusService.isDigitPresent(115,11));
    }
}