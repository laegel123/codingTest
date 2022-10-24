package com.example.codingtest.operatorInter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14888
 */
public class Main {
    static int[] arrInt;
    static int[] operator = new int[4];
    static int number = 0;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        number = Integer.parseInt(br.readLine());

        arrInt = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arrInt[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

        br.close();
    }

    public static void dfs(int n, int depth) {
        if (depth == number) {
            MAX = Math.max(MAX, n);
            MIN = Math.min(MIN, n);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(n + arrInt[depth], depth + 1);

                        break;
                    case 1:
                        dfs(n - arrInt[depth], depth + 1);

                        break;
                    case 2:
                        dfs(n * arrInt[depth], depth + 1);

                        break;
                    case 3:
                        dfs(n / arrInt[depth], depth + 1);

                        break;
                }
                operator[i]++;
            }
        }
    }
}
