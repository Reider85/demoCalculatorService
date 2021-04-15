package com.example.demoCalculatorService;

import com.example.demoCalculatorService.entity.Calculation;
import com.example.demoCalculatorService.entity.CalculationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.Date;

/**
 * Сервис расчета факториала
 */
@RestController
public class FactorialCalc {

    private static final Long FACTORIAL_TYPE=1L;

    @Autowired
    CalculatorService calculatorService;

    /**
     * Сервис расчета факториала
     * @param number входящий параметр
     * @return результат расчета
     */
    @Transactional
    @GetMapping("/factorial")
    public Result service(@RequestParam(value = "number", defaultValue = "0") String number) {
        return calculatorService.calculateToService(number,"factorial",FACTORIAL_TYPE);
    }



}
