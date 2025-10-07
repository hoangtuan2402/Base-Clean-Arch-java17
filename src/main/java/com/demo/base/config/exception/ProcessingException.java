package com.demo.base.config.exception;


import org.apache.commons.lang3.StringUtils;

public class ProcessingException extends ApplicationException {

    public ProcessingException(final Object... objects) {
        super(Errors.DATA_IN_PROCESSING, StringUtils.joinWith(" ", objects));
    }

}
