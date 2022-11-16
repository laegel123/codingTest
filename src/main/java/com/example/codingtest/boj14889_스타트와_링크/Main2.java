package com.example.codingtest.boj14889_스타트와_링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int MIN = Integer.MAX_VALUE;
    static int NUMBER;
    static int[][] ARR;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());
        ARR = new int[NUMBER][NUMBER];
        VISITED = new boolean[NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUMBER; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findTeam(0, 0);

        System.out.println(MIN);
        br.close();
    }

    /**
     * 팀을 나누는 메서드
     * @param idx 시작점
     * @param depth 현재 도달한 깊이
     */
    public static void findTeam(int idx, int depth) {
        if (depth == NUMBER / 2) {
            diff();

            return;
        }

        for (int i = idx; i < NUMBER; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                findTeam(i + 1, depth + 1);
                VISITED[i] = false;
            }
        }
    }

    /**
     * 나누어진 팀들의 능력치를 합산하여 능력치 차이를 구하고, 최솟값이면 업데이트하는 메서드
     */
    public static void diff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 0; i < NUMBER - 1; i++) {
            for (int j = i + 1; j < NUMBER; j++) {
                if (VISITED[i] && VISITED[j]) {
                    startTeamScore += ARR[i][j];
                    startTeamScore += ARR[j][i];
                }
                if (!VISITED[i] && !VISITED[j]) {
                    linkTeamScore += ARR[i][j];
                    linkTeamScore += ARR[j][i];
                }
            }
        }

        MIN = Math.min(MIN, Math.abs(startTeamScore - linkTeamScore));
    }
}
