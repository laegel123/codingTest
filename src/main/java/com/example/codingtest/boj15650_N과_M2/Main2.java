package com.example.codingtest.boj15650_N과_M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int NUMBER;
    static int LENGTH;
    static boolean[] VISITED;
    static int[] ARR;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NUMBER = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());

        ARR = new int[LENGTH + 1];
        VISITED = new boolean[NUMBER + 1];

        dfs(1, 0);

        System.out.println(SB);
        br.close();
    }

    public static void dfs(int x, int depth) {
        if (depth == LENGTH) {
            for (int i = 0; i < LENGTH; i++) {
                SB.append(ARR[i] + " ");
            }
            SB.append("\n");

            return;
        }

        for (int i = x; i <= NUMBER; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                ARR[depth] = i;
                dfs(i + 1, depth + 1);
                VISITED[i] = false;
            }
        }
    }
}
