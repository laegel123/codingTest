package com.example.codingtest.boj11729_하노이_타워;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11729
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        hanoi(number, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    public static void move(int start, int to) {
        sb.append(start).append(" ").append(to).append("\n");
    }

    public static void hanoi(int number, int start, int to, int via) {
        count++;

        if (number == 1) {
            move(start, to);
        } else {
            hanoi(number - 1, start, via, to);
            move(start, to);
            hanoi(number - 1, via, to, start);
        }
    }
}
