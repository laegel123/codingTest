package com.example.codingtest.ageSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10814
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        String[] strArr = new String[number];

        for (int i = 0; i < number; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (e1, e2) -> {
            int e1Age = Integer.parseInt(e1.split("\\s")[0]);
            int e2Age = Integer.parseInt(e2.split("\\s")[0]);
            return e1Age - e2Age;
        });

        for (int i = 0; i < number; i++) {
            sb.append(strArr[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
