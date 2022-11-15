package com.example.codingtest.boj15652_N과_M4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arrInt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        arrInt = new int[length];

        dfs(number, length, 0, 0);

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int number, int length, int start, int depth) {
        if (depth == length) {
            for (int i : arrInt) {
                sb.append(i + " ");
            }

            sb.append("\n");
            return;
        }

        for (int i = start; i < number; i++) {
            arrInt[depth] = i + 1;

            dfs(number, length, start, depth + 1);
            start++;
        }
    }


}
