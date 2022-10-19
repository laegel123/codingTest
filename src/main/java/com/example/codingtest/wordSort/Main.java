package com.example.codingtest.wordSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1181
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        String[] strArr = new String[number];

        for (int i = 0; i < number; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (e1, e2) -> {
            if (e1.length() == e2.length()) {
                int checkCount = 0;
                for (int i = 0; i < e1.length(); i++) {
                    checkCount = e1.charAt(i) - e2.charAt(i);
                    if (checkCount != 0) {
                        break;
                    }
                }

                return checkCount;
            } else {
                return e1.length() - e2.length();
            }
        });

        strArr = Arrays.stream(strArr).distinct().toArray(String[]::new);

        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
