package com.gaolong.aopdemo.enums;

public enum OperationType {

    /**
     * 操作类型
     */
    UNKNOWN("unknown"),
    DELETE("delete"),
    SELECT("select"),
    UPDATE("update"),
    INSERT("insert"),

    MEETING("meeting"),
    MESSAGE("message"),
    VOCATION("vocation");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    OperationType(String s) {
        this.value = s;
    }
}
