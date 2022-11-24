package com.beyond.library.exception;

import com.beyond.library.contants.Code;

/**
 * @author beyond
 * @since 2022/11/11
 */
public class BizException extends RuntimeException {


    private final String code;

    public BizException(final String message) {
        this(Code.FAILED, message);
    }

    public BizException(final String code, final String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
