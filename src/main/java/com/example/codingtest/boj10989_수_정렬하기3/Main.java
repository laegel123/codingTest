package com.example.codingtest.boj10989_수_정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10989
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        int[] arrCountingSortInt = new int[20000001];

        while (number-- > 0) {
            int n = Integer.parseInt(br.readLine());

            arrCountingSortInt[n + 10000000]++;
        }

        for (int i = 0; i < arrCountingSortInt.length; i++) {
            if (arrCountingSortInt[i] > 0) {
                while (arrCountingSortInt[i] != 0) {
                    sb.append(i-10000000).append("\n");
                    arrCountingSortInt[i]--;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
