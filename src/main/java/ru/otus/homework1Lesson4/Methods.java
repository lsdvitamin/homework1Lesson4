package ru.otus.homework1Lesson4;

/**
 * @author Sergei on 15.09.2024 14:40.
 * @project homework1Lesson4
 */

public class Methods {

    @AfterSuite
    public static void termMethod() {
        try {
            System.out.println("Test termMethod was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста termMethod");
        }
    }
    @Disabled(explane = "Сделать вручную")
    @Test(priority = 2)
    public static void testMethod1() {
        try {
            System.out.println("Test testMethod1 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod1");
        }
    }

    @Test(priority = 6)
    public static void testMethod2() {
        try {
            System.out.println("Test testMethod2 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod2");
        }
    }

    @Test(priority = 2)
    public static void testMethod3() {
        try {
            Integer sum = 1 / 0;
            System.out.println("Test testMethod3 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod3");
        }
    }

    @Test(priority = 2)
    public static void testMethod4() {
        try {
            System.out.println("Test testMethod4 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod4");
        }
    }

    @Test(priority = 10)
    public static void testMethod5() {
        try {
            System.out.println("Test testMethod5 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod5");
        }
    }

    @Disabled
    @Test
    public static void testMethod6() {
        try {
            System.out.println("Test testMethod6 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod6");
        }
    }

    @Test(priority = 7)
    public static void testMethod7() {
        try {
            System.out.println("Test testMethod7 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod7");
        }
    }

    @Test
    public static void testMethod8() {
        try {
            System.out.println("Test testMethod8 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod8");
        }
    }

    @Test
    public static void testMethod9() {
        try {
            System.out.println("Test testMethod9 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod9");
        }
    }

    @Test(priority = 1)
    public static void testMethod10() {
        try {
            System.out.println("Test testMethod10 was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста testMethod10");
        }
    }

    @BeforeSuite
    public static void initMethod() {
        try {
            System.out.println("Test initMethod was completed");
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении теста initMethod");
        }
    }


}
