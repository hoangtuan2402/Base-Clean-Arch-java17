package com.demo.base.config;


import com.demo.base.config.exception.Errors;
import com.demo.base.config.http.HttpStatusCode;
import com.demo.base.config.response.BaseResponse;
import com.demo.base.config.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Controller
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    ResponseEntity<BaseResponse<Void>> handleBusinessException(ApplicationException exception) {
        val data = BaseResponse.ofFailed(exception);
        return new ResponseEntity<>(data, mapHttpStatusCode(exception.httpStatusCode()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<BaseResponse<Void>> handleIllegalArgumentException(
            IllegalArgumentException exception) {
        val errorCode = Errors.INVALID_PARAMETERS;
        val data = BaseResponse.ofFailed(errorCode, exception.getMessage());
        return new ResponseEntity<>(data, mapHttpStatusCode(errorCode.httpStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<BaseResponse<Void>> handleException(Exception exception) {
        log.error("{}", exception.getMessage(), exception);
        val errorCode = Errors.INTERNAL_SERVER_ERROR;
        val data = BaseResponse.ofFailed(errorCode, exception.getMessage());
        return new ResponseEntity<>(data, mapHttpStatusCode(errorCode.httpStatusCode()));
    }

    HttpStatus mapHttpStatusCode(final HttpStatusCode code) {
        return HttpStatus.resolve(code.getValue());
    }

}
