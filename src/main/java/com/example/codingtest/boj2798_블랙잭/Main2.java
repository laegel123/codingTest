package com.example.codingtest.boj2798_블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int SCORE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        SCORE = Integer.parseInt(st.nextToken());
        int[] card = new int[number];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(find(card, number));
        br.close();
    }

    public static int find(int[] card, int number) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < number - 2; i++) {
            for (int j = i + 1; j < number - 1; j++) {
                for (int k = j + 1; k < number; k++) {
                    int temp = card[i] + card[j] + card[k];
                    if (temp == SCORE) {
                        return temp;
                    }

                    if (temp <= SCORE) {
                        result = Math.max(result, temp);
                    }
                }
            }
        }

        return result;
    }



}
