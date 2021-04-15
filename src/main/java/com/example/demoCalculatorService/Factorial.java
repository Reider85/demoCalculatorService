package com.example.demoCalculatorService;

import java.math.BigInteger;

/**
 * Калькулятор факториал
 */
public class Factorial implements Calculator {

    /**
     * Расчет факториала
     * @param number Входящий параметр
     * @return факториал
     */
    @Override
    public BigInteger calculate(Integer number){
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= number; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}
