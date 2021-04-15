package com.example.demoCalculatorService;

/**
 * Фабрика калькуляторов
 */
public class CalculatorFactory {

    private static final String FIBONACCI="fibonacci";

    private static final String FACTORIAL="factorial";

    /**
     * Создание калькулятора
     * @param name Название
     * @return один из калькуляторов
     */
    public static Calculator getCalculator(String name){
        if (name==null){
            return null;
        }
        if (FIBONACCI.equals(name)){
            return new Fibonacci();
        }
        if (FACTORIAL.equals(name)){
            return new Factorial();
        }
        return null;
    }
}
