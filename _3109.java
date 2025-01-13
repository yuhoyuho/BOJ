package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3109 {
    static int[][] row = {{-1, 1}, {0, 1}, {1, 1}}; // 순서대로 오른쪽 위, 오른쪽, 오른쪽 아래를 의미
    static char[][] map;
    static boolean[][] visited;
    static int R, C, cnt;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cnt = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        // 탐색 우선 순위 : 오른쪽 위, 오른쪽, 오른쪽 아래

        // 파이프 연결을 완료한 경우
        if(y == C - 1) {
            cnt++;
            visited[x][y] = true;
            flag = true;
            return;
        }

        for(int i = 0; i < 3; i++) {
            int nx = x + row[i][0];
            int ny = y + row[i][1];

            // 유효한 범위인지, 방문처리가 되어있지 않은지, 건물로 막혀있지 않은지 확인
            if(isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == '.') {
                dfs(nx, ny);

                // 하위 dfs 함수가 return 되고 아래 if문을 실행
                // dfs 함수를 재귀적으로 작성하여서 상위 호출로 전파되어 visited를 true 처리 할 수 있음
                if(flag) {
                    visited[x][y] = true;
                    return;
                }
                else {
                    visited[x][y] = true;
                }
            }
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}