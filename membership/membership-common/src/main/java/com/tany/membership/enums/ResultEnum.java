package com.tany.membership.enums;

public enum ResultEnum {
	UNAUTH(401),
    SUCCESS(200),
    ERROR(500)
    ;
    private Integer code;
    ResultEnum(Integer code)
    {
    	this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
