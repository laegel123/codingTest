package com.example.codingtest.sortInside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1427
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] arrInt = new int[10];

        for (int i = 0; i < str.length(); i++) {
            arrInt[str.charAt(i) - '0']++;
        }

        for (int i = arrInt.length - 1; i >= 0; i--) {
            while (arrInt[i] > 0) {
                sb.append(i);
                arrInt[i]--;
            }
        }


        System.out.println(sb);
        br.close();
    }
}
