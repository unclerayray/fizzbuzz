package com.roger.fizzbuzz.exception;

public class NumberTooBigException extends Exception {
    public static int MIN_NUMBER = 1;
    public static int MAX_NUMBER = 10000;

    public NumberTooBigException(String message) {
        super(message);
    }
}
