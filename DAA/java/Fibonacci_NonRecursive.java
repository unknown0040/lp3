package Sem7.DAA;

import java.util.Scanner;

public class Fibonacci_NonRecursive {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
//        int n = 10; // Change this to the desired Fibonacci sequence length.
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}