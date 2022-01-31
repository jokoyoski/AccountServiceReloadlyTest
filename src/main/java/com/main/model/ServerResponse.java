package com.main.model;

public class ServerResponse <T>  {
    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public T getValues() {
        return values;
    }

    public void setValues(T values) {
        this.values = values;
    }

    private String Description;
    private T values;
}
