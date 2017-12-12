package com.dinghy.domain.exception;

/**
 * Created by dinghy on 2017/9/29.
 */
public class SkyException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public SkyException(String message){
        super(message);
    }
}
