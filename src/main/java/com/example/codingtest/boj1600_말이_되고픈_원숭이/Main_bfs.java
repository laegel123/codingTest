package com.example.codingtest.boj1600_말이_되고픈_원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bfs {
    static int SKILL_COUNT; // 말의 능력을 사용할 수 있는 횟수
    static int[][] ARR;
    static boolean[][][] VISITED;
    static int[] DISTANCE_X = {1, 0, -1, 0}; // 상, 하 방향
    static int[] DISTANCE_Y = {0, 1, 0, -1}; // 좌, 우 방향
    static int[] DISTANCE_X_SKILL = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] DISTANCE_Y_SKILL = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int WIDTH;
    static int HEIGHT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        SKILL_COUNT = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        HEIGHT = Integer.parseInt(st.nextToken());
        WIDTH = Integer.parseInt(st.nextToken());

        ARR = new int[WIDTH][HEIGHT];
        VISITED = new boolean[SKILL_COUNT + 1][WIDTH][HEIGHT];
        // SKILL_COUNT + 1 하는 이유는 SKILL을 쓰지 않는 경우의 수도 있기 때문이다.

        for (int i = 0; i < WIDTH; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < HEIGHT; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0, 0, 0));
        br.close();
    }

    /**
     *
     * @param x : x 좌표
     * @param y : y 좌표
     * @param count : 동작수
     * @param skillCount : 사용 스킬 횟수
     * @return
     */
    public static int bfs(int x, int y, int count, int skillCount) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, count, skillCount});
        ARR[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == WIDTH - 1 && now[1] == HEIGHT - 1) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + DISTANCE_X[i];
                int nextY = now[1] + DISTANCE_Y[i];
                int nextCount = now[2] + 1;
                int nextSkillCount = now[3];

                if (nextX >= WIDTH || nextX < 0 || nextY >= HEIGHT || nextY < 0 || ARR[nextX][nextY] == 1 || VISITED[nextSkillCount][nextX][nextY]) {
                    continue;
                }

                VISITED[nextSkillCount][nextX][nextY] = true;
                queue.offer(new int[]{nextX, nextY, nextCount, nextSkillCount});
            }

            if (now[3] != SKILL_COUNT) {
                for (int i = 0; i < 8; i++) {
                    int nextX = now[0] + DISTANCE_X_SKILL[i];
                    int nextY = now[1] + DISTANCE_Y_SKILL[i];
                    int nextCount = now[2] + 1;
                    int nextSkillCount = now[3] + 1;

                    if (nextX >= WIDTH || nextX < 0 || nextY >= HEIGHT || nextY < 0 || ARR[nextX][nextY] == 1 || VISITED[nextSkillCount][nextX][nextY]) {
                        continue;
                    }

                    VISITED[nextSkillCount][nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY, nextCount, nextSkillCount});
                }
            }
        }

        return -1;
    }
}
