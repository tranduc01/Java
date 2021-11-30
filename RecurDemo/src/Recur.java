/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Recur {

    public static double factorial(int n) {
        if (n < 2) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibo(int n) {
        if (n < 2) {
            return 1;
        }
        return fibo(n - 2) + fibo(n - 1);
    }

    public static boolean testFibo(int x) {
        if (x < 1) {
            return false;
        }
        int aFibo = 1;
        int n = 2;
        while (aFibo < x) {
            aFibo = fibo(n++);
        }
        return x == aFibo;
    }

    public static double ap(int n, double a, double d) {
        if (n == 1) {
            return a;
        }
        return ap(n - 1, a, d) + d;
    }

    public static double gp(int n, double a, double q) {
        if (n == 1) {
            return a;
        }
        return gp(n - 1, a, q) * q;
    }

    public static double sum(double[] a, int n) {
        if (n == 0) {
            return 0;
        }
        return sum(a, n - 1) + a[n - 1];
    }

    public static double max(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        return max(a, n - 1) > a[n - 1] ? max(a, n - 1) : a[n - 1];
    }

    public static double min(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        return min(a, n - 1) < a[n - 1] ? min(a, n - 1) : a[n - 1];
    }

    public static String convert(int n, int base) {
        if (n == 0) {
            return "0";
        }
        return convert(n / base, base) + Character.forDigit(n % base, base);
    }

    public static void main(String[] args) {
        //Factorial
        System.out.println("Factorial of 5: " + factorial(5));
        //Fibo
        System.out.println("Check num is in fibo or not?");
        System.out.println("Num: 55 " + testFibo(55));
        System.out.println("Num: 120 " + testFibo(120));
        // Test 1.5   3.5  5.5   7.5   9.5   11.5
        System.out.println("Compute the n item of an arithmetic progression");
        System.out.println(ap(6, 1.5, 2));
        // Test   1.5  3   6  12  24  48
        System.out.println("Compute the n item of a geometric progression");
        System.out.println(gp(6, 1.5, 2));
        //Test
        double[] a = {1.5, 2, 4, 5, 2, 6.5};
        System.out.println("Sum of integral array having n elements");
        System.out.println(sum(a, 6));
        //Test
        int b[] = {5, 9, 1, 7, 2, 19, 10};
        System.out.println("The maximum value in an integral array");
        System.out.println(max(b, 7));
        System.out.println("The minimum value in an integral array");
        System.out.println(min(b, 7));
        //Convert
        System.out.println("----------");
        System.out.println("Binary: " + convert(266, 2));
        System.out.println("Decimal: " + convert(266, 10));
        System.out.println("Octal: " + convert(266, 8));
        System.out.println("Hexadecimal: " + convert(266, 16));
        System.out.println("----------");
    }
}
