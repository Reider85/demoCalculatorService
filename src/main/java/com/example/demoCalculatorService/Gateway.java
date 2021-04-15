package com.example.demoCalculatorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Шлюз
 */
@SpringBootApplication
@RestController
public class Gateway {

    public static void main(String[] args) {
        SpringApplication.run(Gateway.class, args);
    }

    /**
     * Сервис Gateway
     * @param type Тип расчета
     * @param number Входящий параметр
     * @param response HttpServletResponse
     */
    @GetMapping("/gateway")
    public void gateway(@RequestParam(value = "type") String type,@RequestParam(value = "number",defaultValue="0") String number,HttpServletResponse response) {
        try {
            response.sendRedirect("/" + type+"?number="+number);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
