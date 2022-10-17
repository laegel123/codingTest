package com.example.codingtest.star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2447
 */
public class Main {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        star = new char[number][number];

        makeStar(0, 0, number, false);

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    /**
     *
     * @param x
     * @param y
     * @param size 한 블록의 길이
     * @param check : true - 공백
     *                false - 공백 x
     */
    public static void makeStar(int x, int y, int size, boolean check) {
        if (check) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    star[i][j] = ' ';
                }
            }

            return;
        }

        if (size == 1) {
            star[x][y] = '*';
            return;
        }



        int currentSize = size / 3;
        int checkCount = 0;

        for (int i = x; i < x + size; i += currentSize) {
            for (int j = y; j < y + size; j += currentSize) {
                checkCount++;

                // 항상 5번째는 공백이다.
                if (checkCount == 5) {
                    makeStar(i, j, currentSize, true);
                } else {
                    makeStar(i, j, currentSize, false);
                }
            }
        }

    }
}
