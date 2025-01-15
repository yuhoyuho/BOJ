package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17136 {
    static int[][] map = new int[10][10]; // 종이
    static int[] paper = {0, 5, 5, 5, 5, 5}; // 각 크기별 색종이 개수
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if(result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, int cnt) {
        // 범위를 벗어나면 (탐색을 완료하면 개수를 저장하고 return)
        if(x >= 9 && y > 9) {
            result = Math.min(result, cnt);
            return;
        }

        if(result <= cnt) {
            return;
        }

        if(y > 9) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if(map[x][y] == 1) { // 붙여야 하는 칸
            for(int i = 5; i >= 1; i--) {
                if(paper[i] > 0 && isValid(x, y, i)) {
                    cover(x, y, i);
                    paper[i]--;
                    dfs(x, y + 1, cnt + 1);

                    ctrlZ(x, y, i);
                    paper[i]++;
                }
            }
        }
        else { // 넘어가는 칸
            dfs(x, y + 1, cnt);
        }
    }

    static void cover(int x, int y, int size) { // 색종이를 붙임
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                map[i][j] = 0;
            }
        }
    }

    static void ctrlZ(int x, int y, int size) { // 색종이를 뗌 (백트래킹)
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                map[i][j] = 1;
            }
        }
    }

    static boolean isValid(int x, int y, int size) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(i < 0 || j < 0 || i >= 10 || j >= 10 || map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}