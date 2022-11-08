package com.example.codingtest.boj10989_수_정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        int[] countingSort = new int[10001];

        for (int i = 0; i < number; i++) {
            countingSort[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 0; i < countingSort.length; i++) {
            while (countingSort[i] > 0) {
                sb.append(i).append("\n");
                countingSort[i]--;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
