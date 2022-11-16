package com.example.codingtest.boj14888_연산자_끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int NUMBER;
    static int[] ARR;
    static int[] OPERATOR = new int[4];
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());
        ARR = new int[NUMBER];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < NUMBER; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int number = Integer.parseInt(st.nextToken());
            OPERATOR[i] = number;
        }

        dfs(ARR[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
        br.close();
    }

    public static void dfs(int result, int depth) {
        if (depth == NUMBER) {
            MIN = Math.min(MIN, result);
            MAX = Math.max(MAX, result);

            return;
        }

        // 연산을 하나씩 해본다.
        for (int i = 0; i < 4; i++) {
            if (OPERATOR[i] > 0) {
                OPERATOR[i]--;
                switch (i) {
                    case 0 :
                        dfs(result + ARR[depth], depth + 1);
                        break;
                    case 1 :
                        dfs(result - ARR[depth], depth + 1);
                        break;
                    case 2 :
                        dfs(result * ARR[depth], depth + 1);
                        break;
                    case 3 :
                        dfs(result / ARR[depth], depth + 1);
                        break;
                }
                OPERATOR[i]++;
            }
        }
    }

}
