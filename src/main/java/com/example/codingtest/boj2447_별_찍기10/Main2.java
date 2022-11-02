package com.example.codingtest.boj2447_별_찍기10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        star = new char[number][number];
        StringBuilder sb = new StringBuilder();

        drawStar(0, 0, number);

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void drawStar(int x, int y, int depth) {
        if (depth == 1) {
            star[x][y] = '*';

            return;
        }

        int size = depth / 3;
        int checkCount = 0;
        for (int i = x; i < x + depth; i += size) {
            for (int j = y; j < y + depth; j += size) {
                checkCount++;

                if (checkCount == 5) {
                    drawSpace(i, j, size);
                } else {
                    drawStar(i, j, size);
                }
            }
        }
    }

    public static void drawSpace(int x, int y, int depth) {
        for (int i = x; i < x + depth; i++) {
            for (int j = y; j < y + depth; j++) {
                star[i][j] = ' ';
            }
        }
    }
}
