package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19236 {
    static int[][] map;
    static Fish[] fish;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Fish[17];

        // map, fish 배열 초기화
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;

                map[i][j] = num;
                fish[num] = new Fish(i, j, dir, num, true);
            }
        }

        int dir = fish[map[0][0]].dir;
        int cnt = map[0][0];
        fish[cnt].isAlive = false;
        map[0][0] = -1;

        dfs(0, 0, dir, cnt);

        System.out.println(result);
    }

    static void fishmove() {
        for(int i = 1; i <= 16; i++) {
            if(!fish[i].isAlive) {
                continue;
            }

            int dir = fish[i].dir;

            for(int j = 0; j < 8; j++) { // 방향 탐색 시작
                dir %= 8; // dir이 8 이상이 되는 것을 방지

                fish[i].dir = dir;
                int nx = fish[i].x + dx[dir];
                int ny = fish[i].y + dy[dir];

                if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != -1) {
                    if(map[nx][ny] == 0) { // 빈칸이라면 (= 물고기가 없다면)
                        map[fish[i].x][fish[i].y] = 0;
                        fish[i].x = nx;
                        fish[i].y = ny;
                        map[nx][ny] = i;
                    }
                    else { // 다른 물고기가 있다면
                        int change = map[nx][ny]; // 이동할 칸 물고기 번호 num 저장

                        fish[change].x = fish[i].x; // 그 칸에 있던 물고기 현재 물고기 위치로 이동
                        fish[change].y = fish[i].y;
                        map[fish[change].x][fish[change].y] = change;

                        fish[i].x = nx; // 현재 물고기 이동
                        fish[i].y = ny;
                        map[nx][ny] = i;
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
        result = Math.max(result, cnt); // 먹은 물고기 번호의 합 갱신

        int[][] copyMap = new int[4][4]; // map 복사
        for(int i = 0; i < 4; i++) {
            copyMap[i] = map[i].clone();
        }

        Fish[] copyFish = new Fish[17]; // 물고기 배열 복사
        for(int i = 1; i <= 16; i++) {
            copyFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].dir, fish[i].num, fish[i].isAlive);
        }

        fishmove(); // 물고기 이동

        // 상어 이동
        for(int i = 1; i < 4; i++) { // map의 크기가 4이기 때문에 최대 3칸까지 이동 가능
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;

            if(nx >= 0 && ny >= 0 && nx < 4 && ny < 4 && map[nx][ny] != 0) {
                int eat = map[nx][ny];
                int ndir = fish[eat].dir;

                fish[eat].isAlive = false;
                map[x][y] = 0;
                map[nx][ny] = -1;

                dfs(nx, ny, ndir, cnt + eat);

                // 백트래킹
                fish[eat].isAlive = true;
                map[nx][ny] = eat;
                map[x][y] = -1;
            }
        }

        // map, fish 배열 원래대로 되돌리기
        for(int i = 0; i < 4; i++) {
            map[i] = copyMap[i].clone();
        }

        for(int i = 1; i <= 16; i++) {
            fish[i] = new Fish(copyFish[i].x, copyFish[i].y, copyFish[i].dir, copyFish[i].num, copyFish[i].isAlive);
        }
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