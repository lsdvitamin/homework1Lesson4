package ru.otus.homework1Lesson4;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Sergei on 13.09.2024 10:47.
 * @project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("Start tests\n");
        try {
            Testing.test(Methods.class);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            System.out.println("Продолжение выполнения тестов невозможно");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


}

