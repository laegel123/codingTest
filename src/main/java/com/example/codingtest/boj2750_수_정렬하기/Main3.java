package com.example.codingtest.boj2750_수_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        int[] countingSort = new int[2001];

        for (int i = 0; i < number; i++) {
            countingSort[Integer.parseInt(br.readLine()) + 1000]++;
        }

        for (int i = 0; i < 2001; i++) {
            if (countingSort[i] > 0) {
                sb.append(i - 1000).append("\n");
                countingSort[i]--;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
