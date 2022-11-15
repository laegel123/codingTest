package com.example.codingtest.boj15652_N과_M4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int NUMBER;
    static int LENGTH;
    static int[] ARR;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NUMBER = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());
        ARR = new int[LENGTH];

        dfs(1, 0);

        System.out.println(SB);
        br.close();
    }

    public static void dfs(int x, int depth) {
        if (depth == LENGTH) {
            for (int i = 0; i < ARR.length; i++) {
                SB.append(ARR[i] + " ");
            }
            SB.append("\n");

            return;
        }

        for (int i = x; i <= NUMBER; i++) {
            ARR[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
