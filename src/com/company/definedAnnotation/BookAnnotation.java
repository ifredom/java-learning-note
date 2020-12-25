package com.company.definedAnnotation;

import java.lang.annotation.*;

/**
 *
 * 自定义注解：树的信息注解
 *
 * @author Ifredom
 *
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BookAnnotation {
    // 书名
    String bookName();
    // 女主人公
    String heroine();
    // 书的简介
    String briefOfBook();
    // 书的销量
    int sales() default 10000;
}
