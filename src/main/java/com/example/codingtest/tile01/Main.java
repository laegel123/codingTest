package com.example.codingtest.tile01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] TILE;
    static int NUMBER;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NUMBER = Integer.parseInt(br.readLine());
        TILE = new int[NUMBER + 1];

        sequence(NUMBER);

        System.out.println(TILE[NUMBER]);

        br.close();
    }

    public static int sequence(int number) {
        if (number == 0) {
            TILE[number] = 0;

            return 0;
        }
        if (number == 1) {
            TILE[number] = 1;

            return 1;
        }

        if (number == 2) {
            TILE[number] = 2;

            return 2;
        }

        if (TILE[number] != 0) {
            return TILE[number];
        }

        TILE[number] = (sequence(number - 1) + sequence(number - 2)) % 15746;

        return TILE[number];
    }
}
