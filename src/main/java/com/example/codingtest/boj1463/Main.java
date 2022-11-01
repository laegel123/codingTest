package com.example.codingtest.boj1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1463
 */
public class Main {
    static int NUMBER = 0;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        DP = new int[NUMBER + 1];
        DP[0] = DP[1] = 0;

        System.out.println(find(NUMBER));
        br.close();
    }

    public static int find(int number) {
        if (number < 2) {
            return DP[number];
        }

        if (DP[number] != 0) {
            return DP[number];
        }

        if (number % 6 == 0) {
            DP[number] = Math.min(find(number / 3), Math.min(find(number / 2), find(number - 1))) + 1;
        } else if (number % 3 == 0) {
            DP[number] = Math.min(find(number / 3), find(number - 1)) + 1;
        } else if (number % 2 == 0) {
            DP[number] = Math.min(find(number / 2), find(number - 1)) + 1;
        } else {
            DP[number] = find(number - 1) + 1;
        }

        return DP[number];
    }
}
