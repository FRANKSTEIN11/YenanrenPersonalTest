package com.heaboy.annotation;

import java.lang.annotation.*;

/**
 * heaboy 的controller声明
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @ interface Controller {
}
