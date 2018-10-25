package com.roger.fizzbuzz.exception;

public class NumberOutOfRangeException extends Exception {
    public static int MIN_NUMBER = 1;
    public static int MAX_NUMBER = 10000;

    public NumberOutOfRangeException(String message) {
        super(message);
    }
}
