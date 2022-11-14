package com.beyond.library.result;

public interface IResult<T> {

    String getCode();

    String getMessage();

    T getData();

}
