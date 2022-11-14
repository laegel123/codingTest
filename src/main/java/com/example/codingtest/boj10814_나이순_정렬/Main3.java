package com.example.codingtest.boj10814_나이순_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * StringBuilder 를 이용하여 counting sort.
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        StringBuilder[] sbArr = new StringBuilder[201];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());

            if (sbArr[age] == null) {
                sbArr[age] = new StringBuilder();
            } else {
                sbArr[age].append("\n");
            }
            sbArr[age].append(age + " ").append(st.nextToken());
        }

        for (int i = 0; i < 201; i++) {
            if (sbArr[i] != null) {
                System.out.println(sbArr[i]);
            }
        }

        br.close();
    }
}
