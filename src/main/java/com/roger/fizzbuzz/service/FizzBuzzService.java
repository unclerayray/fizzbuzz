package com.roger.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService implements IFizzBuzzService {
    @Override
    public String fizzBuzz(int inputNumber) {
        if (inputNumber%15==0) {
            return "FizzBuzz\n";
        }else if (inputNumber%5==0) {
            return "Buzz\n";
        }else if (inputNumber%3==0){
            return "Fizz\n";
        }else {
            return inputNumber + "\n";
        }
    }
}
