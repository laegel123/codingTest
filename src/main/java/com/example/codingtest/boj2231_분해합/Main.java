package com.example.codingtest.boj2231_분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        System.out.println(getDecomposition(number));
        br.close();
    }

    public static int getDecomposition(int number) {
        for (int i = 0; i < 1000000; i++) {
            int temp = i;
            String str = String.valueOf(i);

            for (int j = 0; j < str.length(); j++) {
                temp += Integer.parseInt(str.substring(j, j + 1));
            }

            if (temp == number) {
                return i;
            }
        }

        return 0;
    }
}
