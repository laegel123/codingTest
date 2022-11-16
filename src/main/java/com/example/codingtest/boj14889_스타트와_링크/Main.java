package com.example.codingtest.boj14889_스타트와_링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14889
 */
public class Main {
    static int NUMBER = 0;
    static int[][] SCORE;
    static boolean[] VISITED;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        NUMBER = Integer.parseInt(br.readLine());
        SCORE = new int[NUMBER][NUMBER];
        VISITED = new boolean[NUMBER];

        for (int i = 0; i < NUMBER; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUMBER; j++) {
                SCORE[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findTeam(0, 0);
        System.out.println(MIN);
        br.close();
    }

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

    public static void diff() {
        int teamStartScore = 0;
        int teamLinkScore = 0;

        for (int i = 0; i < NUMBER - 1; i++) {
            for (int j = i + 1; j < NUMBER; j++) {
                if (VISITED[i] && VISITED[j]) {
                    teamStartScore += SCORE[i][j];
                    teamStartScore += SCORE[j][i];
                } else if (!VISITED[i] && !VISITED[j]) {
                    teamLinkScore += SCORE[i][j];
                    teamLinkScore += SCORE[j][i];
                }
            }
        }

        MIN = Math.min(Math.abs(teamLinkScore - teamStartScore), MIN);
    }
}
