package com.example.codingtest.boj2750_수_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2750
 * 선택 정렬로 풀어봄.
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        int[] arrInt = new int[number];

        for (int i = 0; i < number; i++) {
            arrInt[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < number-1; i++) {
            for (int j = i + 1; j < number; j++) {
                if (arrInt[i] > arrInt[j]) {
                    int temp = arrInt[j];
                    arrInt[j] = arrInt[i];
                    arrInt[i] = temp;
                }
            }
        }

        for (int i : arrInt) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
