package com.example.demoCalculatorService;

import java.math.BigInteger;

/**
 * Калькулятор Фибоначчи
 */
public class Fibonacci implements Calculator {

    /**
     * Расчет числа Фибоначчи
     * @param number Входящий параметр
     * @return число Фибоначчи
     */
    @Override
    public BigInteger calculate(Integer number){
        BigInteger prev=BigInteger.ZERO;
        BigInteger next=BigInteger.ONE;
        BigInteger result=BigInteger.ZERO;
        for (int i = 0; i < number; i++) {
            result=prev.add(next);
            prev=next;
            next=result;
        }
        return result;
    }
}
