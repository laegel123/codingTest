package com.example.codingtest.boj2231_분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        System.out.println(findDecomposition(number));
        br.close();
    }

    public static int findDecomposition(int number) {
        int result = 0;
        for (int i = 1; i < number; i++) {
            result = i;
            for (int j = 0; j < String.valueOf(i).length(); j++) {
                result += String.valueOf(i).charAt(j) - '0';
            }

            if (result == number) {
                return i;
            }
        }

        return 0;
    }
}
