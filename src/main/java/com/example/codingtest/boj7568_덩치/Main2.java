package com.example.codingtest.boj7568_덩치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] RANK;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        RANK = new int[number];
        int[][] people = new int[number][2];

        for (int i = 0; i < number; i++) {
            RANK[i] = 1;
        }

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        findRank(people, number);

        for (int i = 0; i < number; i++) {
            sb.append(RANK[i] + " ");
        }

        System.out.println(sb);
        br.close();
    }

    public static void findRank(int[][] people, int number) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                if (i != j) {
                    if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                        RANK[i]++;
                    }
                }
            }
        }
    }
}
