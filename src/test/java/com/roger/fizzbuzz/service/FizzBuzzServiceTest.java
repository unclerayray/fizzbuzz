package com.roger.fizzbuzz.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzServiceTest {
    public FizzBuzzService fizzBuzzService;

    @Before
    public void setUp() throws Exception {
        fizzBuzzService = new FizzBuzzService();
    }

    @Test
    public void fizzBuzz() {
        Assert.assertEquals("1\n", fizzBuzzService.fizzBuzz(1));
        Assert.assertEquals("2\n", fizzBuzzService.fizzBuzz(2));
        Assert.assertEquals("Fizz\n", fizzBuzzService.fizzBuzz(3));
        Assert.assertEquals("Buzz\n", fizzBuzzService.fizzBuzz(5));
        Assert.assertEquals("Fizz\n", fizzBuzzService.fizzBuzz(6));

        Assert.assertEquals("Buzz\n", fizzBuzzService.fizzBuzz(10));
        Assert.assertEquals("FizzBuzz\n", fizzBuzzService.fizzBuzz(15));
        Assert.assertEquals("Buzz\n", fizzBuzzService.fizzBuzz(55));
        Assert.assertEquals("Buzz\n", fizzBuzzService.fizzBuzz(100));
    }
}