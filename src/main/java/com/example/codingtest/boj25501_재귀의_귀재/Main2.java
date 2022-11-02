package com.example.codingtest.boj25501_재귀의_귀재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            String str = br.readLine();
            COUNT = 0;

            sb.append(isPalindrome(str)).append(" ").append(COUNT).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int recursion(String s, int l, int r) {
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            COUNT++;
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s) {
        COUNT++;
        return recursion(s, 0, s.length() - 1);
    }
}
