package com.example.codingtest.body;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());
        int[][] arrPeople = new int[number][2];


        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());

            arrPeople[i][0] = Integer.parseInt(st.nextToken());
            arrPeople[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] arrLank = getRank(arrPeople, number);

        for (int i = 0; i < arrLank.length; i++) {
            sb.append(arrLank[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    public static int[] getRank(int[][] arrPeople, int number) {
        int[] arrRank = new int[number];

        for (int i = 0; i < number; i++) {
            int rank = 1;

            for (int j = 0; j < number; j++) {
                if (i == j) {
                    continue;
                }

                if (arrPeople[i][0] < arrPeople[j][0] && arrPeople[i][1] < arrPeople[j][1]) {
                    rank++;
                }

                arrRank[i] = rank;
            }
        }

        return arrRank;
    }
}
