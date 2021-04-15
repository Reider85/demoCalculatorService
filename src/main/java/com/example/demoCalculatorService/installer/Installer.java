package com.example.demoCalculatorService.installer;

import com.example.demoCalculatorService.CalculatorFactory;
import com.example.demoCalculatorService.Result;
import com.example.demoCalculatorService.entity.CalculationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.math.BigInteger;

/**
 * Инсталлятор справочников
 */
@RestController
public class Installer {

    @Autowired
    EntityManager entityManager;

    /**
     * Сервис,создающий справочники
     * @return
     */
    @Transactional
    @GetMapping("/install")
    public Result service(){
        CalculationType item=new CalculationType();
        String error=null;
        try {
            addType(1L, "factorial");
            addType(2L, "fibonacci");
        } catch (Exception e){
            e.printStackTrace();
            error=e.getMessage();
        }
        return (error==null)?new Result("ok"):new Result(error);
    }

    @Transactional
    public void addType(Long id,String name) throws Exception{
        CalculationType item=new CalculationType();
        item.setId(id);
        item.setName(name);
        entityManager.merge(item);
    }
}
