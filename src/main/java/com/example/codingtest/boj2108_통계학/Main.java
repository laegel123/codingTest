package com.example.codingtest.boj2108_통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2108
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());
        int[] arrInt = new int[number];
        int[] arrCountingSortInt = new int[8001];
        int[] arrCountingSortIntCopy;

        for (int i = 0; i < number; i++) {
            arrCountingSortInt[Integer.parseInt(br.readLine()) + 4000]++;
        }
        arrCountingSortIntCopy = Arrays.copyOf(arrCountingSortInt, arrCountingSortInt.length);

        int j = 0;
        for (int i = 0; i < arrCountingSortInt.length; i++) {
            while (arrCountingSortInt[i] > 0) {
                arrInt[j] = i - 4000;
                j++;
                arrCountingSortInt[i]--;
            }
        }

        sb.append(getAverage(arrInt) + "\n" + getCenterNumber(arrInt) + "\n" + getManyNumber(arrInt, arrCountingSortIntCopy) + "\n" + getRange(arrInt));

        System.out.println(sb);
        br.close();
    }

    public static int getAverage(int[] arrInt) {
        double total = 0;

        for (int i = 0; i < arrInt.length; i++) {
            total += arrInt[i];
        }

        return (int) Math.round(total/arrInt.length);
    }

    public static int getCenterNumber(int[] arrInt) {
        return arrInt[arrInt.length/2];
    }

    public static int getManyNumber(int[] arrInt, int[] arrCountingSortIntCopy) {
        int result = 0;
        int maxNumber = 0;

        for (int i = 0; i < arrInt.length; i++) {
            maxNumber = Math.max(arrCountingSortIntCopy[arrInt[i] + 4000], maxNumber);
        }

        int count = 0;
        for (int i = 0; i < arrInt.length; i++) {
            if (arrCountingSortIntCopy[arrInt[i] + 4000]-- == maxNumber) {
                count++;
                if (count > 2) {
                    break;
                }
                result = arrInt[i];
            }
        }

        return result;
    }

    public static int getRange(int[] arrInt) {
        return arrInt[arrInt.length - 1] - arrInt[0];
    }
}
