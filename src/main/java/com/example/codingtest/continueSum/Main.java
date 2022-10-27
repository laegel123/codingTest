package com.example.codingtest.continueSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1912
 */
public class Main {
    static int[] SUM;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        SUM = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            MAX = Math.max(MAX, sum(i, Integer.parseInt(st.nextToken())));
        }

        System.out.println(MAX);

        br.close();
    }

    public static int sum(int i, int x) {
        if (i == 0) {
            SUM[i] = x;

            return SUM[i];
        }

        if (SUM[i - 1] + x >= x) {
            SUM[i] = SUM[i - 1] + x;
        } else {
            SUM[i] = x;
        }

        return SUM[i];
    }
}
