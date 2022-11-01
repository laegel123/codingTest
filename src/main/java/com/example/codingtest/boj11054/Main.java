package com.example.codingtest.boj11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11054
 */
public class Main {
    static int NUMBER = 0;
    static Integer[] LEFT_DP;
    static Integer[] RIGHT_DP;
    static int[] SEQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        LEFT_DP = new Integer[NUMBER];
        RIGHT_DP = new Integer[NUMBER];
        SEQ = new int[NUMBER];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < NUMBER; i++) {
            SEQ[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < NUMBER; i++) {
            findLeftDp(i);
            findRightDp(i);
        }

        int max = 0;
        for (int i = 0; i < NUMBER; i++) {
            max = Math.max(LEFT_DP[i] + RIGHT_DP[i], max);
        }

        System.out.println(max - 1);
        br.close();
    }

    public static int findLeftDp(int number) {
        if (LEFT_DP[number] == null) {
            LEFT_DP[number] = 1;

            for (int i = number - 1; i >= 0; i--) {
                if (SEQ[number] > SEQ[i]) {
                    LEFT_DP[number] = Math.max(LEFT_DP[number], findLeftDp(i) + 1);
                }
            }
        }

        return LEFT_DP[number];
    }

    public static int findRightDp(int number) {
        if (RIGHT_DP[number] == null) {
            RIGHT_DP[number] = 1;

            for (int i = number + 1; i < NUMBER; i++) {
                if (SEQ[number] > SEQ[i]) {
                    RIGHT_DP[number] = Math.max(RIGHT_DP[number], findRightDp(i) + 1);
                }
            }
        }

        return RIGHT_DP[number];
    }

}
