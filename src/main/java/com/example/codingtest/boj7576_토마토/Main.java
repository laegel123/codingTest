package com.example.codingtest.boj7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int WIDTH;
    static int HEIGHT;
    static int[][] ARR;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};
    static int COUNT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HEIGHT = Integer.parseInt(st.nextToken());
        WIDTH = Integer.parseInt(st.nextToken());
        ARR = new int[WIDTH][HEIGHT];

        for (int i = 0; i < WIDTH; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                int x = Integer.parseInt(st.nextToken());
                ARR[i][j] = x;
            }
        }

        // 큐에 먼저 익은 토마토를 담는다.
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (ARR[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs(queue);

        System.out.println(COUNT);
        br.close();
    }

    public static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DISTANCE_X[i];
                int nextY = now[1] + DISTANCE_Y[i];

                if (nextX < 0 || nextX >= WIDTH || nextY < 0 || nextY >= HEIGHT) {
                    continue;
                }

                if (ARR[nextX][nextY] == 0) {
                    queue.add(new int[]{nextX, nextY});
                    ARR[nextX][nextY] = ARR[now[0]][now[1]] + 1;
                }

            }
        }

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (ARR[i][j] == 0) {
                    COUNT = -1;

                    return;
                }

                if (COUNT < ARR[i][j]) {
                    COUNT = ARR[i][j];
                }
            }
        }

        // 토마토가 다 익은경우.
        if (COUNT == 1) {
            COUNT = 0;

            return;
        }

        // 처음 시작이 1부터 시작하기때문에 -1 해준다 .
        COUNT--;
    }




}
