package com.example.codingtest.boj18870_좌표_압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18870
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int number = Integer.parseInt(br.readLine());
        int[] inputArr = new int[number];
        int[] inputArrSort;
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < number; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        inputArrSort = Arrays.copyOf(inputArr, inputArr.length);

        Arrays.sort(inputArrSort);

        int count = 0;
        for (int i = 0; i < inputArrSort.length; i++) {
            if (!rankMap.containsKey(inputArrSort[i])) {
                rankMap.put(inputArrSort[i], count);
                count++;
            }
        }

        for (int i = 0; i < inputArr.length; i++) {
            sb.append(rankMap.get(inputArr[i]) + " ");
        }

        System.out.println(sb);
        br.close();
    }
}
