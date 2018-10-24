package com.roger.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzPlusService implements IFizzBuzzService {
    @Override
    public String fizzBuzz(int inputNumber) {
        if ((inputNumber%5==0 || isDigitPresent(inputNumber, 5)) && (inputNumber%3==0 || isDigitPresent(inputNumber, 3))) {
            return "FizzBuzz\n";
        }else if (inputNumber%5==0 || isDigitPresent(inputNumber, 5)) {
            return "Buzz\n";
        }else if (inputNumber%3==0 || isDigitPresent(inputNumber, 3)){
            return "Fizz\n";
        }else {
            return inputNumber + "\n";
        }
    }

    public boolean isDigitPresent(int x, int d){
        while (x > 0){
            if (x % 10 == d) {
                break;
            }
            x = x / 10;
        }

        return (x > 0);
    }
}
