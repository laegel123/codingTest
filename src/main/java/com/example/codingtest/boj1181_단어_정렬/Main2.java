package com.example.codingtest.boj1181_단어_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        String[] words = new String[number];

        for (int i = 0; i < number; i++) {
            words[i] = br.readLine();
        }

        words = Arrays.stream(words).distinct().toArray(String[]::new);

        Arrays.sort(words, (e1, e2) -> {
            if (e1.length() == e2.length()) {
                for (int i = 0; i < e1.length(); i++) {
                    if (e1.charAt(i) != e2.charAt(i)) {
                        return e1.charAt(i) - e2.charAt(i);
                    }
                }
            }

            return e1.length() - e2.length();
        });

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
