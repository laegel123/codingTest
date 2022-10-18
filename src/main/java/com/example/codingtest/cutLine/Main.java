package com.example.codingtest.cutLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/25305
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfStudent = Integer.parseInt(st.nextToken());
        int numberOfCutLine = Integer.parseInt(st.nextToken());

        int[] arrCountingSortInt = new int[10001];
        int cutLineScore = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberOfStudent; i++) {
            int score = Integer.parseInt(st.nextToken());

            arrCountingSortInt[score]++;
        }

        int tempInt = 0;
        for (int i = arrCountingSortInt.length - 1; i >= 0; i--) {
            while (arrCountingSortInt[i] > 0) {
                arrCountingSortInt[i]--;
                tempInt++;

                if (tempInt == numberOfCutLine) {
                    cutLineScore = i;
                    break;
                }
            }
        }

        System.out.println(cutLineScore);
        br.close();
    }
}
