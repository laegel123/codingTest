package com.example.codingtest.boj1018_체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

/**
 * https://www.acmicpc.net/problem/1018
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        char[][] board = new char[width][height];

        for (int i = 0; i < width; i++) {
            String str = br.readLine();

            for (int j = 0; j < height; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        System.out.println(getDrawCount(board, width, height));
        br.close();
    }

    public static int getDrawCount(char[][] board, int width, int height) {
        int count = MAX_VALUE;

        for (int i = 0; i < width-7; i++) {
            for (int j = 0; j < height-7; j++) {
                char base = board[i][j];
                int temp = 0;

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {

                        if (board[i + k][j + l] != base) {
                            temp++;
                        }

                        if (base == 'W') {
                            base = 'B';
                        } else if (base == 'B') {
                            base = 'W';
                        }
                    }

                    if (base == 'W') {
                        base = 'B';
                    } else if (base == 'B') {
                        base = 'W';
                    }
                }
                temp = Math.min(temp, 64 - temp);

                count = Math.min(count, temp);
            }
        }

        return count;
    }


}
