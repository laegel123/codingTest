package com.example.codingtest.boj1600_말이_되고픈_원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_dfs_fail {
    static int NUMBER;
    static int[][] ARR;
    static int WIDTH;
    static int HEIGHT;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};

    static int[] DISTANCE_X_HORSE = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] DISTANCE_Y_HORSE = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HEIGHT = Integer.parseInt(st.nextToken());
        WIDTH = Integer.parseInt(st.nextToken());
        ARR = new int[WIDTH][HEIGHT];

        for (int i = 0; i < WIDTH; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);

        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }

        br.close();
    }

    public static void dfs(int x, int y, int count, int horse) {
        if (x == WIDTH - 1 && y == HEIGHT - 1) {
            MIN = Math.min(MIN, count);

            return;
        }

        if (x > WIDTH - 1 || y > HEIGHT - 1) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nowX = x + DISTANCE_X[i];
            int nowY = y + DISTANCE_Y[i];

            if (nowX >= 0 && nowX < WIDTH && nowY >= 0 && nowY < HEIGHT && ARR[nowX][nowY] == 0) {
                ARR[nowX][nowY] = 1;
                dfs(nowX, nowY, count + 1, horse);
                ARR[nowX][nowY] = 0;
            }

        }

        if (horse != NUMBER) {
            for (int i = 0; i < 8; i++) {
                int nowX = x + DISTANCE_X_HORSE[i];
                int nowY = y + DISTANCE_Y_HORSE[i];

                if (nowX >= 0 && nowX < WIDTH && nowY >= 0 && nowY < HEIGHT && ARR[nowX][nowY] == 0) {
                    ARR[nowX][nowY] = 1;
                    dfs(nowX, nowY, count + 1, horse + 1);
                    ARR[nowX][nowY] = 0;
                }
            }
        }

    }
}
