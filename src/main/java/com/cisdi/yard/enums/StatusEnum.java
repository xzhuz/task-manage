package com.cisdi.yard.enums;

/**
 * @author meisen
 * @since 2021-05-10
 */
public enum StatusEnum {

    ENABLED(1),
    DISABLED(2),
    ;

    private Integer code;

    StatusEnum(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}