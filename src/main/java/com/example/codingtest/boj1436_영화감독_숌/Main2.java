package com.example.codingtest.boj1436_영화감독_숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        System.out.println(findMovie(number));
        br.close();
    }

    public static int findMovie(int number) {
        int result = 665;
        int count = 0;
        while (true) {
            result++;
            if (String.valueOf(result).contains("666")) {
                count++;
            }

            if (count == number) {
                return result;
            }
        }
    }
}
