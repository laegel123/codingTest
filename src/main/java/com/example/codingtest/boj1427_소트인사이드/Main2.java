package com.example.codingtest.boj1427_소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] countingSort = new long[10];
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            countingSort[str.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            while (countingSort[i] > 0) {
                sb.append(i);
                countingSort[i]--;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
