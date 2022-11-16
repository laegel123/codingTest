package com.example.codingtest.boj2580_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2580
 */
public class Main {
    static int[][] sudoku = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);

        System.out.println(sb);
        br.close();
    }

    public static void sudoku(int x, int y) {
        if (y == 9) {
            sudoku(x + 1, 0);

            return;
        }

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

        if (sudoku[x][y] == 0) {
            for (int i = 1; i < 10; i++) {
                if (isPossible(x, y, i)) {
                    sudoku[x][y] = i;

                    sudoku(x, y + 1);
                }
            }
            sudoku[x][y] = 0;

            return;
        }

        sudoku(x, y + 1);
    }

    public static boolean isPossible(int x, int y, int value) {
        int startX = (x / 3) * 3;
        int startY = (y / 3 * 3);

        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == value) {
                return false;
            }

            if (sudoku[i][y] == value) {
                return false;
            }
        }

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (sudoku[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }


}
