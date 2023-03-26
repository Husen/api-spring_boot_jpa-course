package com.example.demo.utils.specification;

import com.example.demo.utils.constant.Operator;

public class SearchCriteria {
    private String key;
    private Operator operator;
    private String value;

    public SearchCriteria(String key, Operator operator, String value) {
        this.key = key;
        this.operator = operator;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
