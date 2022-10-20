package com.example.codingtest.nAndM_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15649
 */
public class Main {
    static int[] arrInt;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        arrInt = new int[length];
        visited = new boolean[number];

        dfs(number, length, 0);

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int number, int length, int depth) {
        if (depth == length) {
            for (int i : arrInt) {
                sb.append(i + " ");
            }

            sb.append("\n");

            return;
        }
        for (int i = 0; i < number; i++) {
            if (!visited[i]) {
                arrInt[depth] = i + 1;
                depth++;
                visited[i] = true;

                dfs(number, length, depth);

                depth--;
                visited[i] = false;
            }
        }
    }
}
