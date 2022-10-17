package com.example.codingtest.mergeSort;

/**
 * https://www.acmicpc.net/problem/24060
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arrInt;
    static int[] arrIntTemp;
    static int count = 0;
    static int k = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arrInt = new int[number];
        arrIntTemp = new int[number];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < number; i++) {
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        merge(0, number - 1);

        System.out.println(result);;
        br.close();
    }

    public static void merge(int start, int end) {
        if (count > k) {
            return;
        }

        if (start < end) {
            int mid = (start + end) / 2;
            merge(start, mid);
            merge(mid + 1, end);
            sort(start, mid, end);
        }
    }

    public static void sort(int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= end) {
            if (arrInt[i] <= arrInt[j]) {
                arrIntTemp[t] = arrInt[i];
                i++;
            } else {
                arrIntTemp[t] = arrInt[j];
                j++;
            }

            t++;
        }

        while (i <= mid) {
            arrIntTemp[t] = arrInt[i];
            t++;
            i++;
        }

        while (j <= end) {
            arrIntTemp[t] = arrInt[j];
            t++;
            j++;
        }

        i = start;
        t = 0;

        while (i <= end) {
            count ++;
            if (count == k) {
                result = arrIntTemp[t];
                break;
            }

            arrInt[i] = arrIntTemp[t];
            i++;
            t++;
        }
    }
}
