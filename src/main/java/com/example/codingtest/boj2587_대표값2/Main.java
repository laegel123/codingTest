package com.example.codingtest.boj2587_대표값2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[101];
        int sum = 0;
        int centerNumber = 0;

        for (int i = 0; i < 5; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[number]++;
            sum += number;
        }

        int count = 0;
        for (int i = 0; i < 101; i++) {
            while (arr[i] > 0) {
                count++;
                arr[i]--;

                if (count == 3) {
                    centerNumber = i;
                    break;
                }
            }
        }

        sb.append(sum / 5).append("\n").append(centerNumber);
        System.out.println(sb);
        br.close();
    }
}
