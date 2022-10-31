package com.example.codingtest.boj10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10844
 */
public class Main {
    static int NUMBER;
    static long[][] stairs;
    static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        stairs = new long[NUMBER + 1][10];
        long result = 0;

        for (int i = 0; i < 10; i++) {
            stairs[1][i] = 1;
        }

        for (int i = 1; i < 10; i++) {
            result += recursion(NUMBER, i);
        }

        System.out.println(result % MOD);
        br.close();
    }

    public static long recursion(int digit, int val) {
        if (digit == 1) {
            return stairs[digit][val];
        }

        if (stairs[digit][val] != 0) {
            return stairs[digit][val];
        }

        if (val == 0) {
            stairs[digit][val] = recursion(digit - 1, val + 1);
        } else if (val == 9) {
            stairs[digit][val] = recursion(digit - 1, val - 1);
        } else {
            stairs[digit][val] = recursion(digit - 1, val - 1) + recursion(digit - 1, val + 1);
        }

        return stairs[digit][val] % MOD;
    }
}
