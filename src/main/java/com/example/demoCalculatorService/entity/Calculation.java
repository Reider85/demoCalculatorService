package com.example.demoCalculatorService.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Сущность Расчет
 */
@Entity
@Table(name = "calculation")
public class Calculation implements Serializable {

    private Long id;

    private Integer number;

    private String  result;

    private CalculationType type;

    private Date date;

    public Calculation(){

    }

    public Calculation (Integer number, BigInteger result,CalculationType type){
        setNumber(number);
        setResult(String.valueOf(result));
        setType(type);
        setDate(new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Column(columnDefinition = "text")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @ManyToOne
    public CalculationType getType() {
        return type;
    }

    public void setType(CalculationType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
