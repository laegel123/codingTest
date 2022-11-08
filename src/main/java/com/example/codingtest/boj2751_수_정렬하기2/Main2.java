package com.example.codingtest.boj2751_수_정렬하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] countingSort = new int[2000001];
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            countingSort[Integer.parseInt(br.readLine()) + 1000000]++;
        }

        for (int i = 0; i < countingSort.length; i++) {
            while (countingSort[i] > 0) {
                sb.append(i - 1000000).append("\n");
                countingSort[i]--;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
