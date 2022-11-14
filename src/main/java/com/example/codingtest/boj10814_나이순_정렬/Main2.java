package com.example.codingtest.boj10814_나이순_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 객체 이용하여 풀어보기
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        Person[] person = new Person[number];

        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(person, (e1, e2) -> {
            return e1.age - e2.age;
        });

        for (int i = 0; i < number; i++) {
            sb.append(person[i].toString()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age + " " + this.name;
    }

}


