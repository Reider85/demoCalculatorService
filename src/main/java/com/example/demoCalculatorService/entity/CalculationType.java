package com.example.demoCalculatorService.entity;

import javax.persistence.*;

/**
 * Сущность тип расчета
 */
@Entity
@Table(name = "calculation_type")
public class CalculationType {

    private Long id;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
