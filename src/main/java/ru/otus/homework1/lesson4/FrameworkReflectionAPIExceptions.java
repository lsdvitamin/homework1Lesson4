package ru.otus.homework1.lesson4;

/**
 * @author Sergei on 17.09.2024 22:12.
 * @project homework1Lesson4
 */
public class FrameworkReflectionAPIExceptions extends Exception {
    public FrameworkReflectionAPIExceptions(String message) {
        super(message);
        System.out.println(message);
    }
}