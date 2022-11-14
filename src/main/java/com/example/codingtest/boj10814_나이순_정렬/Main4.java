package com.example.codingtest.boj10814_나이순_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        Member[] member = new Member[number];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            member[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(member, (e1, e2) -> {
            return e1.age - e2.age;
        });

        for (int i = 0; i < number; i++) {
            sb.append(member[i].toString()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

class Member {
    int age;
    String name;

    Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age + " " +this.name;
    }
}
