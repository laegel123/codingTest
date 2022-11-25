package com.example.codingtest.boj2331_반복수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> ARR_LIST = new ArrayList<>();
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        dfs(number, p);

        System.out.println(SB);
        br.close();
    }

    public static void dfs(int v, int p) {
        if (ARR_LIST.contains(v)) {
            SB.append(ARR_LIST.indexOf(v));
            return;
        }

        ARR_LIST.add(v);

        String str = String.valueOf(v);
        int next = 0;
        for (int i = 0; i < str.length(); i++) {
            next += Math.pow(str.charAt(i) - '0', p);
        }

        dfs(next, p);
    }
}
