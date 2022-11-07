package com.example.codingtest.boj25305_커트라인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int numberOfCuteLine = Integer.parseInt(st.nextToken());
        int[] countingSort = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            countingSort[Integer.parseInt(st.nextToken())]++;
        }

        int cuteLineCount = 0;
        for (int i = 10000; i >= 0; i--) {
            while (countingSort[i] > 0) {
                cuteLineCount++;
                countingSort[i]--;

                if (cuteLineCount == numberOfCuteLine) {
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}
