package com.example.codingtest.boj2108_통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] countingSort = new int[8001];

        for (int i = 0; i < arr.length; i++) {
            countingSort[arr[i] + 4000]++;
        }

        int[] countingSortCopy = Arrays.copyOf(countingSort, countingSort.length);
        int[] countingSortCopy2 = Arrays.copyOf(countingSort, countingSort.length);

        sb.append(findAvg(arr) + "\n" + findMedian(arr.length/2, countingSort) + "\n" + findMod(arr, countingSortCopy) + "\n" + findRange(countingSortCopy2));
        System.out.println(sb);
        br.close();
    }

    public static int findAvg(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (int)Math.round(sum / arr.length);
    }

    public static int findMedian(int number, int[] countingSort) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < countingSort.length; i++) {
            while (countingSort[i] > 0) {
                countingSort[i]--;
                count++;

                if (count == number + 1) {
                    return result = i - 4000;
                }
            }
        }

        return result;
    }

    public static int findMod(int[] arr, int[] countingSort) {
        int result = 0;
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            maxNumber = Math.max(countingSort[arr[i] + 4000], maxNumber);
        }

        int count = 0;
        for (int i = 0; i < countingSort.length; i++) {
            if (countingSort[i] == maxNumber) {
                count++;
                result = i - 4000;

                if (count == 2) {
                    break;
                }
            }
        }

        return result;
    }

    public static int findRange(int[] countingSort) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < countingSort.length; i++) {
            if (countingSort[i] > 0) {
                min = i - 4000;
                break;
            }
        }

        for (int i = countingSort.length - 1; i >= 0; i--) {
            if (countingSort[i] > 0) {
                max = i - 4000;
                break;
            }
        }

        return Math.abs(max - min);
    }

}
