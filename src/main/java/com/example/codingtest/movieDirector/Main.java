package com.example.codingtest.movieDirector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1436
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int movieNumber = 665;
        int count = 0;

        while (count != number) {
            movieNumber++;

            if (String.valueOf(movieNumber).contains("666")) {
                count++;
            }
        }

        System.out.println(movieNumber);
        br.close();
    }
}
