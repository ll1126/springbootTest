package com.test.Util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * jsonp跨域
 */
@ControllerAdvice(basePackages = "com.test.Controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonpAdvice() {

        super("callback","jsonp");
    }
}
