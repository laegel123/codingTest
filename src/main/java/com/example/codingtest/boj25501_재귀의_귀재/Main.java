package com.example.codingtest.boj25501_재귀의_귀재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/25501
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        while (number-- > 0) {
            String str = br.readLine();
            count = 0;

            sb.append(isPalindrome(str, 0, str.length() - 1) + " " + count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int isPalindrome(String str, int left, int right) {
        count++;
        if (left >= right) {
            return 1;
        } else if (str.charAt(left) != str.charAt(right)) {
            return 0;
        } else {
            return isPalindrome(str, left + 1, right - 1);
        }
    }
}
