package com.example.codingtest.boj2178_미로_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] MAZE;
    static boolean[][] VISITED;
    static int X;
    static int Y;
    static int[] DISTANCE_X = {1, 0, -1, 0};
    static int[] DISTANCE_Y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        MAZE = new int[X][Y];
        VISITED = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String str = br.readLine();
            for (int j = 0; j < Y; j++) {
                MAZE[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(MAZE[X - 1][Y - 1]);
        br.close();
    }

    // 최단거리를 구할 때는 bfs 기법을 이용하면 좋다.
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 상하좌우 4 방향으로 움직일 수 있으므로, 반복문을 4번 돌린다.
            for (int i = 0; i < 4; i++) {
                int newX = now[0] + DISTANCE_X[i];
                int newY = now[1] + DISTANCE_Y[i];

                // 새로운 좌표가 범위에 맞지 않으면 통과시킨다.
                if (newX < 0 || newY < 0 || newX >= X || newY >= Y) {
                    continue;
                }

                // 새로운 좌표가 길이 아니면 통과시킨다.
                if (MAZE[newX][newY] == 0) {
                    continue;
                }

                if (!VISITED[newX][newY]) {
                    // 새로운 좌표에 방문한다.
                    VISITED[newX][newY] = true;
                    // 해당 좌표에 도달하기 위한 최단거리를 입력한다.
                    MAZE[newX][newY] = MAZE[now[0]][now[1]] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }
}
