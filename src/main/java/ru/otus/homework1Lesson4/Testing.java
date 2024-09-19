package ru.otus.homework1Lesson4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Sergei on 17.09.2024 15:53.
 * @project homework1Lesson4
 */

public class Testing {

    public static void test(Class<?> cl) throws MyException, InvocationTargetException, IllegalAccessException {
        Method[] methods = cl.getDeclaredMethods();
        if (cl.isAnnotationPresent(Disabled.class)) {
            System.out.println(cl.getAnnotation(Disabled.class).explane());
            return;
        }

        ArrayList<Method> methodsWithDisableAnn = new ArrayList();
        ArrayList<Method> methodsWithBeforeAnn = new ArrayList();
        ArrayList<Method> methodsWithAfterAnn = new ArrayList();
        ArrayList<Method> methodsWithOnlyTestAnn = new ArrayList();

        for (Method method : methods) {
            if ((method.isAnnotationPresent(Test.class)) && (method.isAnnotationPresent(BeforeSuite.class)) ||
                    (method.isAnnotationPresent(Test.class)) && (method.isAnnotationPresent(AfterSuite.class))) {
                throw new MyException("Две несовместимые аннотации для метода " + method.getName());
            }

            if ((method.isAnnotationPresent(BeforeSuite.class)) && (!method.isAnnotationPresent(Disabled.class))) {
                methodsWithBeforeAnn.add(method);
            }

            if ((method.isAnnotationPresent(Test.class)) && (!method.isAnnotationPresent(Disabled.class))) {
                methodsWithOnlyTestAnn.add(method);
            }

            if ((method.isAnnotationPresent(AfterSuite.class)) && (!method.isAnnotationPresent(Disabled.class))) {
                methodsWithAfterAnn.add(method);
            }

            if (method.isAnnotationPresent(Disabled.class)) {
                methodsWithDisableAnn.add(method);
            }

            if (methodsWithBeforeAnn.size() > 1) {
                throw new MyException("В классе две аннотации BeforeSuite");
            }

            if (methodsWithAfterAnn.size() > 1) {
                throw new MyException("В классе две аннотации AfterSuite");
            }
        }

        methodsWithBeforeAnn.get(0).invoke(null);

        for (int i = 10; i > 0; i--) {
            for (Method met : methodsWithOnlyTestAnn) {
                if (met.getAnnotation(Test.class).priority() == i) {
                    met.invoke(null);
                }
            }
        }

        methodsWithAfterAnn.get(0).invoke(null);

        System.out.println();
        for (Method met : methodsWithDisableAnn) {
            System.out.println("Тест " + met.getName() + " отключен (" + met.getAnnotation(Disabled.class).explane() + ")");
        }

        System.out.println("\nВсего тестов: " + (Methods.successfullyTest + Methods.badTest + methodsWithDisableAnn.size()) + "\n" +
                "Успешно выполнено: " + Methods.successfullyTest + "\n" +
                "Отключен: " + methodsWithDisableAnn.size() + "\n" +
                "Упало: " + Methods.badTest);

    }
}
