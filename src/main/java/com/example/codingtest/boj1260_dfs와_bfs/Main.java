package com.example.codingtest.boj1260_dfs와_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int V;
    static int[][] ARR;
    static boolean[] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        ARR = new int[N + 1][N + 1];
        VISITED = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ARR[x][y] = 1;
            ARR[y][x] = 1;
        }

        dfs(V, 0);
        SB.append("\n");
        VISITED = new boolean[N + 1];
        bfsQueue(V);

        System.out.println(SB);
        br.close();
    }

    public static void dfs(int v, int depth) {
        if (!VISITED[v]) {
            VISITED[v] = true;
            SB.append(v + " ");
        }

        if (depth == N) {
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!VISITED[i] && ARR[v][i] != 0) {
                dfs(i, depth + 1);
            }
        }
    }

    public static void bfsQueue(int v) {
        Queue<Integer> queue = new LinkedList<>();
        VISITED[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int number = queue.poll();
            SB.append(number + " ");

            for (int i = 1; i <= N; i++) {
                if (!VISITED[i] && ARR[number][i] > 0) {
                    VISITED[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}
