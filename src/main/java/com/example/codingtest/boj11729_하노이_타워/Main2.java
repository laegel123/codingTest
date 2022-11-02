package com.example.codingtest.boj11729_하노이_타워;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static StringBuilder SB = new StringBuilder();
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        hanoi(number, 1, 2, 3);

        System.out.println(COUNT);
        System.out.println(SB);
        br.close();
    }

    public static void move(int start, int end) {
        COUNT++;
        SB.append(start + " " + end + "\n");
    }

    public static void hanoi(int number, int start, int via, int end) {
        if (number == 1) {
            move(start, end);

            return;
        }

        hanoi(number - 1, start, end, via);
        move(start, end);
        hanoi(number - 1, via, start, end);
    }
}
