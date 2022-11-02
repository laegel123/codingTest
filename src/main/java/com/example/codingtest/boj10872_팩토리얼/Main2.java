package com.example.codingtest.boj10872_팩토리얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int NUMBER = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());

        System.out.println(factorial(NUMBER));
        br.close();
    }

    public static int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
