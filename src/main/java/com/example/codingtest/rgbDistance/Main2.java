package com.example.codingtest.rgbDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1149
 */
public class Main2 {
    static int NUMBER = 0;
    static int[][] COST;
    static int[][] HOUSE;
    static int MIN = Integer.MAX_VALUE;

    static int RED = 0;
    static int GREEN = 1;
    static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());

        COST = new int[NUMBER][3];
        HOUSE = new int[NUMBER][3];

        for (int i = 0; i < NUMBER; i++) {
            st = new StringTokenizer(br.readLine());
            COST[i][RED] = Integer.parseInt(st.nextToken());
            COST[i][GREEN] = Integer.parseInt(st.nextToken());
            COST[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        HOUSE[0][RED] = COST[0][RED];
        HOUSE[0][GREEN] = COST[0][GREEN];
        HOUSE[0][BLUE] = COST[0][BLUE];

        System.out.println(Math.min(paint(NUMBER-1, RED), Math.min(paint(NUMBER-1, BLUE), paint(NUMBER-1, GREEN))));
        br.close();
    }

    public static int paint(int number, int color) {
        if (HOUSE[number][color] == 0) {
            if (color == RED) {
                HOUSE[number][RED] = Math.min(paint(number - 1, GREEN), paint(number - 1, BLUE)) + COST[number][RED];
            } else if (color == GREEN) {
                HOUSE[number][GREEN] = Math.min(paint(number - 1, RED), paint(number - 1, BLUE)) + COST[number][GREEN];
            } else if (color == BLUE) {
                HOUSE[number][BLUE] = Math.min(paint(number - 1, RED), paint(number - 1, GREEN)) + COST[number][BLUE];
            }
        }

        return HOUSE[number][color];
    }
}

