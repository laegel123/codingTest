package com.example.codingtest.boj15650_N과_M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        dfs(number, length, 0, 0);

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int number, int length, int start, int depth) {
        if (depth == length) {
            for (int i = 0; i < length; i++) {
                sb.append(arrInt[i]+ " ");
            }

            sb.append("\n");

            return;
        }


        for (int i = start; i < number; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrInt[depth] = i + 1;
                depth++;
                start = i;

                dfs(number, length, start, depth);

                depth--;
                visited[i] = false;

            }
        }
    }
}
