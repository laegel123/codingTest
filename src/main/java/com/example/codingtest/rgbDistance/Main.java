package com.example.codingtest.rgbDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1149
 */
public class Main {
    static int NUMBER = 0;
    static int[][] COST;
    static int[] HOUSE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());

        COST = new int[NUMBER][3];
        HOUSE = new int[NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            st = new StringTokenizer(br.readLine());
            COST[i][0] = Integer.parseInt(st.nextToken());
            COST[i][1] = Integer.parseInt(st.nextToken());
            COST[i][2] = Integer.parseInt(st.nextToken());
        }

        findCost(0, 0);

        System.out.println(MIN);

        br.close();
    }

    public static void findCost(int cost, int depth) {
        if (depth == 2 && HOUSE[depth - 1] == HOUSE[depth - 2]) {
            return;
        }

        if (depth == NUMBER && HOUSE[depth - 1] == HOUSE[depth - 2]) {
            return;
        }

        if (2 <= depth && depth <= NUMBER - 1 && (HOUSE[depth - 1] == HOUSE[depth - 2] || HOUSE[depth - 1] == HOUSE[depth])) {
            return;
        }


        if (depth == NUMBER) {
            MIN = Math.min(cost, MIN);

            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                HOUSE[depth] = 1;
            }
            if (i == 1) {
                HOUSE[depth] = 2;
            }
            if (i == 2) {
                HOUSE[depth] = 3;
            }
            findCost(cost + COST[depth][i], depth + 1);
            HOUSE[depth] = 0;
        }
    }
}

