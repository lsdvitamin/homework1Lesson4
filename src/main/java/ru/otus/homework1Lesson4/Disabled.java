package ru.otus.homework1Lesson4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Sergei on 15.09.2024 14:57.
 * @project homework1Lesson4
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Disabled {
    String explane() default "Тестирование недоступно";
}
