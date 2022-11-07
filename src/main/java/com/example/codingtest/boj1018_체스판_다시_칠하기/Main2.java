package com.example.codingtest.boj1018_체스판_다시_칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        char[][] chess = new char[width][height];

        for (int i = 0; i < width; i++) {
            String str = br.readLine();
            for (int j = 0; j < height; j++) {
                chess[i][j] = str.charAt(j);
            }
        }

        System.out.println(findCount(chess, width, height));
        br.close();
    }

    public static int findCount(char[][] chess, int width, int height) {
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < width - 7; i++) {
            for (int j = 0; j < height - 7; j++) {
                char base = chess[i][j];
                int tempCount = 0;

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (chess[k][l] != base) {
                            tempCount++;
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

                tempCount = Math.min(tempCount, 64 - tempCount);

                count = Math.min(tempCount, count);
            }
        }

        return count;
    }


}
