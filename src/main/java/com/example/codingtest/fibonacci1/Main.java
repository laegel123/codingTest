package com.example.codingtest.fibonacci1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/24416
 */
public class Main {
    static int[] arrInt;
    static int fibonacciCount = 0;
    static int fibonacci2Count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        arrInt = new int[number];

        fibonacci(number);
        fibonacci2(number);

        sb.append(fibonacciCount + " " + fibonacci2Count);
        System.out.println(sb);

        br.close();
    }

    public static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            fibonacciCount++;

            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static int fibonacci2(int number) {
        arrInt[0] = arrInt[1] = 1;
        for (int i = 2; i < number; i++) {
            fibonacci2Count++;
            arrInt[i] = arrInt[i - 1] + arrInt[i - 2];
        }

        return arrInt[number - 1];
    }
}
