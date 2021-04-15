package com.example.demoCalculatorService;

import com.example.demoCalculatorService.entity.Calculation;
import com.example.demoCalculatorService.entity.CalculationType;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.ApplicationScope;


import javax.persistence.EntityManager;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * Подготовка результата расчета
 */
@ApplicationScope
@Component
public class CalculatorService implements Serializable{

    @Autowired
    EntityManager entityManager;

    /**
     * Сохранение результата расчета в базу
     * @param param Входящий параметр
     * @param result Результат расчета
     * @param typeId ID справочника расчета
     * @return успешно или нет
     */
    @Transactional
    public Boolean saveCalculate(Integer param, BigInteger result, Long typeId){
        try {
            CalculationType type = entityManager.find(CalculationType.class, typeId);
            Calculation calculation = new Calculation(param, result, type);
            entityManager.merge(calculation);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Получение результата расчета
     * @param number Входящий параметр
     * @param type  Тип расчета
     * @param typeId ID справочника типа расчета
     * @return
     */
    public Result calculateToService(String number,String type,Long typeId){
        Integer param=null;
        BigInteger result=null;
        String errorCode=null;
        String errorMessage=null;
        try {
            param = Integer.valueOf(number);
        } catch (Exception e){
            errorCode="1";
            errorMessage=e.getMessage();
        }
        if (param!=null) {
            if ((param>-1)&&(param<=100000)){
                result = CalculatorFactory.getCalculator(type).calculate(param);
                if (!saveCalculate(param, result, typeId)){
                    errorCode="2";
                    errorMessage="database saving error";
                }
            } else {
                errorCode = "3";
                if (param>-1) {
                    errorMessage = "max input value 100000.This is bigger input value.";
                } else {
                    errorMessage = "input value not positive.";
                }
            }
        }
        return (errorCode==null)?new Result(String.valueOf(result)):new Result(errorCode,errorMessage);
    }
}
