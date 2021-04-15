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

/**
 * Сервис расчета числа Фибоначчи
 */
@RestController
public class FibonacciCalc {

    private static final Long FIBONACCI_TYPE=2L;

    @Autowired
    CalculatorService calculatorService;

    /**
     * Сервис расчета числа Фибоначчи
     * @param number входящий параметр
     * @return результат расчета
     */
    @Transactional
    @GetMapping("/fibonacci")
    public Result service(@RequestParam(value = "number", defaultValue = "0") String number) {
        return calculatorService.calculateToService(number,"fibonacci",FIBONACCI_TYPE);
    }

}
