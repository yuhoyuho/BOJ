package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2580 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    static void sudoku(int row, int col) {

        // 한 줄 다 채운 경우
        if(col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 모든 칸 다 채운 경우 종료
        if(row == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        // 현재 메서드에서는 열 먼저 채우니까 재귀로 col + 1 호출
        if(map[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }

            map[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    static boolean check(int row, int col, int value) {
        // 행 검사
        for(int i = 0; i < 9; i++) {
            if(map[row][i] == value) {
                return false;
            }
        }

        // 열 검사
        for(int i = 0; i < 9; i++) {
            if(map[i][col] == value) {
                return false;
            }
        }

        // 3 * 3칸 검사
        for(int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for(int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if(map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
