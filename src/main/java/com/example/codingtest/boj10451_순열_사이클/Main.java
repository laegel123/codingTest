package com.example.codingtest.boj10451_순열_사이클;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ARR;
    static boolean[] VISITED;
    static int CYCLE_COUNT;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());

        while (number-- > 0) {
            // 초기화
            CYCLE_COUNT = 0;
            int length = Integer.parseInt(br.readLine());
            ARR = new int[length + 1];
            VISITED = new boolean[length + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < length + 1; i++) {
                ARR[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i < length + 1; i++) {
                if (!VISITED[i]) {
                    dfs(i);
                    CYCLE_COUNT++;
                }
            }

            SB.append(CYCLE_COUNT + "\n");
        }

        System.out.println(SB);
        br.close();
    }

    public static void dfs(int now) {
        VISITED[now] = true;

        int next = ARR[now];
        if (!VISITED[next]) {
            dfs(next);
        }
    }
}
