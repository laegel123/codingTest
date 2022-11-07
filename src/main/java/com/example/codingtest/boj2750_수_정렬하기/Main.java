package com.example.codingtest.boj2750_수_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2750
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        boolean[] arrBool = new boolean[1001];
        boolean[] arrMinusBool = new boolean[1001];

        for (int i = 0; i < number; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n < 0) {
                arrMinusBool[Math.abs(n)] = true;
            } else {
                arrBool[n] = true;
            }
        }

        for (int i = 1000; i >= 0; i--) {
            if (arrMinusBool[i]) {
                sb.append(i * -1).append("\n");
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (arrBool[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
