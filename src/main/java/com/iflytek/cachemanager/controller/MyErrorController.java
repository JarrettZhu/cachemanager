package com.iflytek.cachemanager.controller;

import com.iflytek.cachemanager.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 * 处理404错误
 */
@Slf4j
@Controller
public class MyErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";
    private static MyErrorController appErrorController;
    /**
     * Error Attributes in the Application
     */
    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * Controller for the Error Controller
     *
     * @param errorAttributes
     */

    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    public MyErrorController() {
        if (appErrorController == null) {
            appErrorController = new MyErrorController(this.errorAttributes);
        }
    }

    /**
     * Supports other formats like JSON, XML
     *
     * @param request
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Result error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, this.getTraceParameter(request));
        HttpStatus status = this.getStatus(request);
        return Result.newFailure(new ResponseEntity<>(body, status), null);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @SuppressWarnings("static-method")
    private boolean getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        Map<String, Object> map = this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
        log.error("map is [{}]", map);
        String url = request.getRequestURL().toString();
        map.put("URL", url);
        log.error("[error info]: status-{}, request url-{}", map.get("status"), url);
        return map;
    }

    @SuppressWarnings("static-method")
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            return HttpStatus.valueOf(statusCode);
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
