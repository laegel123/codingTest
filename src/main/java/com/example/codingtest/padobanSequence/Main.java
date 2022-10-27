package com.example.codingtest.padobanSequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9461
 */
public class Main {
    static long[] PADOBAN = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        PADOBAN[0] = 0;
        PADOBAN[1] = 1;
        PADOBAN[2] = 1;
        PADOBAN[3] = 1;
        PADOBAN[4] = 2;
        PADOBAN[5] = 2;

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());

            sb.append(sequence(Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    public static long sequence(int number) {
        if (PADOBAN[number] != 0 || number < 6) {
            return PADOBAN[number];
        }

        PADOBAN[number] = sequence(number - 1) + sequence(number - 5);

        return PADOBAN[number];
    }
}
