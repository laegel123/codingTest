package com.example.codingtest.body;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int number = Integer.parseInt(br.readLine());
        int[] arrWeight = new int[number];
        int[] arrHeight = new int[number];


        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());

            arrWeight[i] = Integer.parseInt(st.nextToken());
            arrHeight[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static void getLank(int[] arrWeight, int[] arrHeight, int number) {
        int[] arrLank = new int[number];

        arrLank[0] = 1;
        for (int i = 0; i < number; i++) {
            while (arrLank[i] == 0) {
                for (int j = 0; j < i; j++) {
                    if (arrWeight[i] == arrWeight[j] && arrHeight[i] == arrHeight[j]) {
                        arrLank[j]++;
                        arrLank[i] = arrLank[j];
                    }
                    //
                    if (arrWeight[i] > arrWeight[j] && arrHeight[i] > arrHeight[j]) {
                        arrLank[i] = arrLank[j];
                        arrLank[j]++;
                    }

                    if (arrWeight[i] > arrWeight[j] && arrHeight[i] < arrHeight[j]) {
                        arrLank[j]++;
                        arrLank[i] = arrLank[j];
                    }
                }
            }
        }
    }
}
