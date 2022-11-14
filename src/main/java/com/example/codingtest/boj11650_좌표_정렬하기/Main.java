package com.example.codingtest.boj11650_좌표_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11650
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());
        int[][] coordinateArr = new int[number][2];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            coordinateArr[i][0] = Integer.parseInt(st.nextToken());
            coordinateArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinateArr, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < number; i++) {
            sb.append(coordinateArr[i][0] + " " + coordinateArr[i][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
