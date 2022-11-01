package com.example.codingtest.boj2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2156
 */
public class Main {
    static int NUMBER;
    static Integer[] DP;
    static int[] WINE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        DP = new Integer[NUMBER + 1];
        WINE = new int[NUMBER + 1];

        for (int i = 1; i < NUMBER + 1; i++) {
            WINE[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = WINE[0];
        DP[1] = WINE[1];

        if (NUMBER > 1) {
            DP[2] = WINE[1] + WINE[2];
        }

        System.out.println(drinking(NUMBER));
        br.close();
    }

    public static int drinking(int number) {
        if (DP[number] == null) {
            DP[number] = Math.max(Math.max(drinking(number - 2), drinking(number - 3) + WINE[number - 1]) + WINE[number], drinking(number-1));
        }

        return DP[number];
    }
}
