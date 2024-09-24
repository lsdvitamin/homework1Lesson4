package ru.otus.homework1.lesson4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Sergei on 17.09.2024 15:53.
 * @project homework1Lesson4
 */

public class Testing {

    static Integer successfullyTest = 0;
    static Integer badTest = 0;

    public static void test(Class<?> cl) throws FrameworkReflectionAPIExceptions, InvocationTargetException, IllegalAccessException {
        Method[] methods = cl.getDeclaredMethods();
        if (cl.isAnnotationPresent(Disabled.class)) {
            System.out.println(cl.getAnnotation(Disabled.class).explane());
            return;
        }

        List<Method> methodsWithDisableAnn = new ArrayList();
        List<Method> methodsWithBeforeAnn = new ArrayList();
        List<Method> methodsWithAfterAnn = new ArrayList();
        Map<Integer, List> methodsWithOnlyTestAnn = new TreeMap<>(Comparator.reverseOrder());

        for (Method method : methods) {
            if ((method.isAnnotationPresent(Test.class)) && (method.isAnnotationPresent(BeforeSuite.class)) ||
                    (method.isAnnotationPresent(Test.class)) && (method.isAnnotationPresent(AfterSuite.class))) {
                throw new FrameworkReflectionAPIExceptions("Две несовместимые аннотации для метода " + method.getName());
            }

            if ((method.isAnnotationPresent(BeforeSuite.class)) && (!method.isAnnotationPresent(Disabled.class))) {
                methodsWithBeforeAnn.add(method);
            }

            if ((method.isAnnotationPresent(Test.class)) && (!method.isAnnotationPresent(Disabled.class))) {
                methodsWithOnlyTestAnn.computeIfAbsent(method.getAnnotation(Test.class).priority(), k -> new ArrayList<>()).add(method);
            }

            if ((method.isAnnotationPresent(AfterSuite.class)) && (!method.isAnnotationPresent(Disabled.class))) {
                methodsWithAfterAnn.add(method);
            }

            if (method.isAnnotationPresent(Disabled.class)) {
                methodsWithDisableAnn.add(method);
            }

            if (methodsWithBeforeAnn.size() > 1) {
                throw new FrameworkReflectionAPIExceptions("В классе две аннотации BeforeSuite");
            }

            if (methodsWithAfterAnn.size() > 1) {
                throw new FrameworkReflectionAPIExceptions("В классе две аннотации AfterSuite");
            }
        }

        if (methodsWithBeforeAnn.size() == 1) {
            try {
                methodsWithBeforeAnn.get(0).invoke(null);
            } catch (Exception e) {
                System.out.println("Ошибка при выполнении теста " + methodsWithBeforeAnn.get(0).getName());
            }
        }

        for (Map.Entry<Integer, List> entry : methodsWithOnlyTestAnn.entrySet()) {
            for (Object lst : entry.getValue()) {
                Method m = (Method) lst;
                try {
                    m.invoke(null);
                    System.out.print(" (priority = " + entry.getKey() + ")\n");
                    successfullyTest++;
                } catch (Exception e) {
                    System.out.println("Ошибка при выполнении теста " + m.getName());
                    badTest++;
                }
            }
        }

        if (methodsWithAfterAnn.size() == 1) {
            try {
                methodsWithAfterAnn.get(0).invoke(null);
            } catch (Exception e) {
                System.out.println("Ошибка при выполнении теста " + methodsWithAfterAnn.get(0).getName());
            }
        }

        System.out.println();
        for (Method met : methodsWithDisableAnn) {
            System.out.println("Тест " + met.getName() + " отключен (" + met.getAnnotation(Disabled.class).explane() + ")");
        }

        System.out.println("\nВсего тестов: " + (successfullyTest + badTest + methodsWithDisableAnn.size()) + "\n" +
                "Успешно выполнено: " + successfullyTest + "\n" +
                "Отключен: " + methodsWithDisableAnn.size() + "\n" +
                "Упало: " + badTest);

    }
}

