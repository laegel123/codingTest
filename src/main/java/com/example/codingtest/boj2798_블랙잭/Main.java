package com.example.codingtest.boj2798_블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        int[] arrInt = new int[number];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < number; i++) {
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getBlackJack(arrInt, number, value));
        br.close();
    }

    public static int getBlackJack(int[] arrInt, int number, int value) {
        int result = 0;

        for (int i = 0; i < number - 2; i++) {
            for (int j = i + 1; j < number - 1; j++) {
                for (int k = j + 1; k < number; k++) {
                    int temp = arrInt[i] + arrInt[j] + arrInt[k];

                    if (temp == value) {
                        return temp;
                    }

                    if (result < temp && temp < value) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }
}
