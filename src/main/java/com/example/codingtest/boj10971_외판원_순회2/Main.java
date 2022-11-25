package com.example.codingtest.boj10971_외판원_순회2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] ARR;
    static boolean[] VISITED;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());
        ARR = new int[number][number];
        VISITED = new boolean[number];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < number; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < number; i++) {
            VISITED = new boolean[number];
            VISITED[i] = true;
            dfs(i, 0, i);
        }

        System.out.println(MIN);
        br.close();
    }

    public static void dfs(int v, int cost, int arrival) {
        if (isAllVisited()) {
            if (ARR[v][arrival] != 0) {
                MIN = Math.min(MIN, cost + ARR[v][arrival]);
            }

            return;
        }

        for (int i = 0; i < ARR.length; i++) {
            if (!VISITED[i] && ARR[v][i] != 0) {
                VISITED[i] = true;
                dfs(i, cost + ARR[v][i], arrival);
                VISITED[i] = false;
            }
        }
    }

    public static boolean isAllVisited() {
        for (int i = 0; i < VISITED.length; i++) {
            if (!VISITED[i]) {
                return false;
            }
        }

        return true;
    }
}
