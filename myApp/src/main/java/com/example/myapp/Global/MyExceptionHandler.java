package com.example.myapp.Global;

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
    public Response exceptionHandler(Exception e){
        System.out.println("未知异常！原因是:"+e);
        return ResponseBuilder.createExceptionRes(e);
    }


}
