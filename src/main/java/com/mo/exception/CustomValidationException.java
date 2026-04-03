package com.mo.exception;

import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String field;
    private final String errorCode;

    public CustomValidationException(String field, String errorCode, String message) {
        super(message);
        this.field = field;
        this.errorCode = errorCode;
    }

}
