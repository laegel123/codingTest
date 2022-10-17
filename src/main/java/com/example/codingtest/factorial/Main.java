package com.example.codingtest.factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10872
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int result = getFactorial(number);

        System.out.println(result);
        br.close();
    }

    public static int getFactorial(int number) {
        if (number <= 1) {
            return 1;
        }

        return number * getFactorial(number - 1);
    }


}
