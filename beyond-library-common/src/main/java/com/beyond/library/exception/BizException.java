package com.beyond.library.exception;

/**
 * @author beyond
 * @since 2022/11/11
 */
public class BizException extends RuntimeException {

    private static final String DEFAULT_CODE = "fail";

    private final String code;

    public BizException(final String message) {
        this(DEFAULT_CODE, message);
    }

    public BizException(final String code, final String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
