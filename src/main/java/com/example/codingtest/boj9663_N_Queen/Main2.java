package com.example.codingtest.boj9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int NUMBER;
    static int[] ARR;
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        ARR = new int[NUMBER];

        dfs(0);

        System.out.println(COUNT);
        br.close();
    }

    public static void dfs(int depth) {
        if (depth == NUMBER) {
            COUNT++;

            return;
        }

        for (int i = 0; i < NUMBER; i++) {
            ARR[depth] = i;

            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        // 현재 깊이까지 탐색하며 현재 위치가 대각선에 위치하는지, 같은 줄에 위치하는지 알아본다.
        for (int i = 0; i < depth; i++) {
            // 대각선에 존재하는지 확인한다.
            // |x2 - x1| == |y2 - y1| 일 경우 대각선 성립.
            if (Math.abs(i - depth) == Math.abs(ARR[i] - ARR[depth])) {
                return false;
            }

            // 같은줄에 존재하는지 확인한다.
            if (ARR[i] == ARR[depth]) {
                return false;
            }
        }

        return true;
    }


}
