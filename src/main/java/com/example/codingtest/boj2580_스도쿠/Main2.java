package com.example.codingtest.boj2580_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] ARR = new int[9][9];
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                ARR[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);

            return;
        }

        // x가 9가 될 때는 순회가 1번 다 끝났을 때이다.
        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    SB.append(ARR[i][j] + " ");
                }
                SB.append("\n");
            }

            System.out.println(SB);
            System.exit(0);
        }

        // 수도쿠 판 중 비어있는 값일 있을 때
        if (ARR[x][y] == 0) {
            for (int i = 1; i < 10; i++) {
                // 비어있는 값에 1~9 중 들어갈 수 있는 숫자를 찾는다.
                if (isPossible(x, y, i)) {
                    ARR[x][y] = i;
                    dfs(x, y + 1);
                }
            }

            // 1~9 중 (x,y) 좌표에 가능한 값이 없으면 return 시켜서 이전 값을 바꾸도록 유도한다.
            ARR[x][y] = 0;

            return;
        }

        dfs(x, y + 1);
    }

    // value 가 (x, y) 좌표에 올 수 있는 값인지 확인한다.
    public static boolean isPossible(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            // 가로에 같은 숫자가 있는지 확인한다.
            if (ARR[x][i] == value) {
                return false;
            }

            // 세로에 같은 숫자가 있는지 확인한다.
            if (ARR[i][y] == value) {
                return false;
            }
        }

        // 3*3 좌표에 같은 숫자가 있는지 확인한다.
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (ARR[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }


}
