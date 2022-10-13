package com.example.codingtest.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/10870
 */
public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());


        System.out.println(getFibonacci(number));
        //System.out.println(getFibonacci2(number));

        br.close();

    }

    public static int getFibonacci(int number) {
        int[] arrNumber = new int[21];

        int i = 0;
        while (i <= number) {
            if (i == 0) {
                arrNumber[0] = 0;
            } else if (i == 1) {
                arrNumber[1] = 1;
            } else {
                arrNumber[i] = arrNumber[i - 1] + arrNumber[i - 2];
            }

            i++;
        }

        return arrNumber[number];
    }

    public static int getFibonacci2(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return getFibonacci2(number - 1) + getFibonacci2(number - 2);
        }
    }


}
