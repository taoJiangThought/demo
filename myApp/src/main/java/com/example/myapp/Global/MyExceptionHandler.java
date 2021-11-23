package com.example.myapp.Global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jiangtaotao
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        HttpStatus httpStatus = HttpStatus.valueOf("500");
        ResponseEntity responseEntity = new ResponseEntity(httpStatus);
        return e.getMessage();
    }


}
