package com.company.definedAnnotation;

import java.lang.annotation.*;


/**
 * 自定义注解：作者信息注解
 *
 * 必须设置@Target和@Retention
 * @Retention一般设置为RUNTIME
 * 自定义的注解通常要求在运行期读取。一般情况下，不必写@Inherited和@Repeatable
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorAnnotation {
    // 名字
    String name();
    // 年龄
    int age() default 19;
    // 性别
    String gender() default "男";
}
