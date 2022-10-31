package com.example.codingtest.boj1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1932
 */
public class Main {
    static int[][] COST;
    static int NUMBER;
    static int[][] VAL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());
        COST = new int[NUMBER][NUMBER];
        VAL = new int[NUMBER][NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;

            while (st.hasMoreTokens()) {
                COST[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for (int i = 0; i < NUMBER; i++) {
            VAL[NUMBER - 1][i] = COST[NUMBER - 1][i];
        }

        System.out.println(triangle(0, 0));
        br.close();
    }

    public static int triangle(int i, int j) {
        if (i == NUMBER - 1) {
            return VAL[i][j];
        }

        if (VAL[i][j] == 0) {
            VAL[i][j] = Math.max(triangle(i + 1, j), triangle(i + 1, j + 1)) + COST[i][j];
        }

        return VAL[i][j];
    }
}
