package com.example.codingtest.boj11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11053
 */
public class Main {
    static int NUMBER = 0;
    static Integer[] DP;
    static int[] SEQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        SEQ = new int[NUMBER];
        DP = new Integer[NUMBER];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUMBER; i++) {
            SEQ[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < NUMBER; i++) {
            find(i);
        }

        int max = DP[0];

        for (int i = 1; i < NUMBER; i++) {
            max = Math.max(max, DP[i]);
        }

        System.out.println(max);
        br.close();
    }

    public static int find(int number) {
        if (DP[number] == null) {
            DP[number] = 1;

            for (int i = number - 1; i >= 0; i--) {
                if (SEQ[number] > SEQ[i]) {
                    DP[number] = Math.max(DP[number], find(i) + 1);
                }
            }
        }

        return DP[number];
    }
}
