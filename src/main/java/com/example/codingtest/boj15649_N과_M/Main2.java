package com.example.codingtest.boj15649_N과_M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static StringBuilder SB = new StringBuilder();
    static int NUMBER;
    static int LENGTH;
    static boolean[] VISITED;
    static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NUMBER = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());

        VISITED = new boolean[NUMBER + 1];
        ARR = new int[LENGTH];

        dfs(0);

        System.out.println(SB);
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == LENGTH) {
            for (int i = 0; i < LENGTH; i++) {
                SB.append(ARR[i] + " ");
            }
            SB.append("\n");

            return;
        }

        for (int i = 1; i <= NUMBER; i++) {
            if (!VISITED[i]) {
                ARR[depth] = i;
                VISITED[i] = true;
                dfs(depth + 1);
                VISITED[i] = false;
            }
        }
    }
}
