package com.example.codingtest.boj18870_좌표_압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 복사 배열을 만들고 정렬한다.
        int[] rank = Arrays.copyOf(arr, arr.length);

        Arrays.sort(rank);

        // 정렬된 배열을 순차로 반복하며 중복되지 않은 값만 count 값을 0부터 증가시키며 저장한다.
        int count = 0;
        for (int i = 0; i < rank.length; i++) {
            if (!map.containsKey(rank[i])) {
                map.put(rank[i], count);
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.println(sb);
        br.close();
    }
}
