package com.example.codingtest.nQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arrInt;
    static int number;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        arrInt = new int[number];

        nQueen(0);

        System.out.println(count);
        br.close();
    }

    public static void nQueen(int depth) {
        if (depth == number) {
            count++;

            return;
        }

        for (int i = 0; i < number; i++) {
            arrInt[depth] = i;

            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arrInt[i] == arrInt[depth]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(arrInt[depth] - arrInt[i])) {
                return false;
            }
        }

        return true;
    }

}
