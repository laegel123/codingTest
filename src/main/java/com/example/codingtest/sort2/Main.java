package com.example.codingtest.sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2751
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        boolean[] arrBool = new boolean[2000001];

        while (number-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arrBool[n+1000000] = true;
        }

        for (int i = 0; i < arrBool.length; i++) {
            if (arrBool[i]) {
                sb.append(i - 1000000).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
