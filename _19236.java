package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19236 {
    static int[][] map = new int[4][4];
    static Fish[] fish;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void fishmove() {
        for(int i = 1; i <= 16; i++) {
            if(!fish[i].isAlive) {
                continue;
            }

            int nx = 0;
            int ny = 0;
            int dir = fish[i].dir;

            for(int j = 0; j < 8; j++) { // 방향 탐색 시작
                dir %= 8; // dir이 8 이상이 되는 것을 방지

                fish[i].dir = dir;
                nx = fish[i].x + dx[dir];
                ny = fish[i].y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
                    if(map[nx][ny] == 0) { // 빈칸이라면 (= 물고기가 없다면)
                        map[fish[i].x][fish[i].y] = 0;
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = fish[i].num;
                    }
                    else { // 다른 물고기가 있다면
                        int change = fish[map[nx][ny]].num; // 현재 물고기 num 저장

                        fish[i].x = nx; // 현재 물고기 이동
                        fish[i].y = ny;
                        map[nx][ny] = fish[i].num;

                        fish[change].x = fish[i].x; // 그 칸에 있던 물고기 현재 물고기 위치로 이동
                        fish[change].y = fish[i].y;
                        map[fish[i].x][fish[i].y] = change;
                    }
                    break;
                }
                else {
                    dir++;
                }
            }
        }
    }

    static void dfs(int x, int y, int dir, int cnt) { // 상어 움직임
        cnt = Math.max(result, cnt); // 먹은 물고기 번호의 합 갱신
        

    }

    static class Shark {
        int x, y, dir, eat; // x, y 좌표 , 방향, 먹은 물고기의 번호의 합

        public Shark(int x, int y, int dir, int eat) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.eat = eat;
        }
    }

    static class Fish {
        int x, y, dir, num; // x, y 좌표 , 방향, 물고기 번호
        boolean isAlive;

        public Fish(int x, int y, int dir, int num, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
            this.isAlive = isAlive;
        }
    }
}
