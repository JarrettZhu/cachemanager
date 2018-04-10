package com.iflytek.cachemanager.exception;

import com.iflytek.cachemanager.result.Result;
import com.iflytek.cachemanager.util.ThrowableUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Result allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        // exception.printStackTrace();
        log.error("报错了：" + ThrowableUtils.printStackTraceToString(exception));
        return Result.newFailure(exception.getMessage(), null);
    }

}
