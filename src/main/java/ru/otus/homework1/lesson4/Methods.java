package ru.otus.homework1.lesson4;

/**
 * @author Sergei on 15.09.2024 14:40.
 * @project homework1Lesson4
 */
public class Methods {

    @AfterSuite
    public static void termMethod() {
        System.out.println("Test termMethod was completed");
    }

    @Disabled(explane = "Сделать вручную")
    @Test(priority = 2)
    public static void testMethod1() {
        System.out.print("Test testMethod1 was completed");
    }

    @Test(priority = 6)
    public static void testMethod2() {
        System.out.print("Test testMethod2 was completed");
    }

    @Test(priority = 2)
    public static void testMethod3() {
        Integer sum = 1 / 0;
        System.out.print("Test testMethod3 was completed");
    }

    @Test(priority = 2)
    public static void testMethod4() {
        System.out.print("Test testMethod4 was completed");
    }

    @Test(priority = 10)
    public static void testMethod5() {
        System.out.print("Test testMethod5 was completed");
    }

    @Test(priority = 2)
    public static void testMethod6() {
        System.out.print("Test testMethod6 was completed");
    }

    @Test(priority = 7)
    public static void testMethod7() {
        System.out.print("Test testMethod7 was completed");
    }

    @Test
    public static void testMethod8() {
        System.out.print("Test testMethod8 was completed");
    }

    @Test
    public static void testMethod9() {
        System.out.print("Test testMethod9 was completed");
    }

    @Test(priority = 1)
    public static void testMethod10() {
        System.out.print("Test testMethod10 was completed");
    }

    @BeforeSuite
    public static void initMethod() {
        System.out.println("Test initMethod was completed");
    }


}
