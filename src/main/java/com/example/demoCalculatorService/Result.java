package com.example.demoCalculatorService;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Вспомогательный класс для генерации JSON результата
 */
public class Result implements Serializable {
    private String value;
    private String errorCode;
    private String errorMessage;

    public Result(String value){
        setValue(value);
    }

    public Result(String errorCode,String errorMessage){
        setErrorCode(errorCode);
        setErrorMessage(errorMessage);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }



    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
