package com.example.codingtest.boj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2579
 */
public class Main {
    static int[] SCORE;
    static int[] VAL;
    static int NUMBER;
    static int MAX_SCORE = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        SCORE = new int[NUMBER + 1];
        VAL = new int[NUMBER + 1];

        for (int i = 1; i < NUMBER + 1; i++) {
            SCORE[i] = Integer.parseInt(br.readLine());
        }

        VAL[0] = -1;
        VAL[1] = SCORE[1];

        if (NUMBER >= 2) {
            VAL[2] = SCORE[1] + SCORE[2];
        }

        System.out.println(find(NUMBER));
        br.close();
    }

    static int find(int number) {
        if (VAL[number] == 0) {
            VAL[number] = Math.max(find(number - 2), find(number - 3) + SCORE[number - 1]) + SCORE[number];
        }

        if (number == 0) {
            return 0;
        }

        return VAL[number];
    }

    public static int stairs(int x) {
        if (VAL[x] == 0) {
            VAL[x] = Math.max(stairs(x - 2), stairs(x - 3) + SCORE[x - 1]) + SCORE[x];
        }

        return VAL[x];
    }
}
