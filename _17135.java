package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17135 {
    static int[][] map;
    static int[][] copyMap;
    static int n, m, d, result;
    static ArrayList<Integer> archer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        copyMap = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }
        archer = new ArrayList<>();
        result = 0;
        place(0, m - 1, 0, archer);

        System.out.println(result);
    }

    static void rollBack() { // map 백트래킹
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    static void place(int start, int range, int cnt, ArrayList<Integer> archer) {
        if(cnt == 3) {
            rollBack(); // map 초기화
            attack(archer); // 게임 시작
            return;
        }

        // dfs로 궁수 배치 조합
        for(int i = start; i <= range; i++) {
            archer.add(i);
            place(start + 1, range, cnt + 1, archer);
            archer.remove(archer.size() - 1);
        }
    }

    static void attack(ArrayList<Integer> archer) {
        int cnt = 0;

        for(int i = 0; i < n; i++) { // 최대 n번 반복(모든 행에 적이 있는 경우)
            boolean[][] visited = new boolean[n][m];

            for(int pos : archer) {
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                int minD = Integer.MAX_VALUE;

                for(int j = 0; j < n; j++) {
                    for(int k = 0; k < m; k++) {
                        if(map[j][k] == 1) {
                            int dist = getDist(j, k, n, pos);

                            if(minD >= dist) {
                                if(minD > dist) {
                                    minX = j;
                                    minY = k;
                                    minD = dist;
                                }
                                else {
                                    if(minY > k) {
                                        minX = j;
                                        minY = k;
                                    }
                                }
                            }
                        }
                    }
                }
                if(minD <= d) {
                    visited[minX][minY] = true;
                }
            }

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(visited[j][k]) {
                        map[j][k] = 0;
                        cnt++;
                    }
                }
            }
            move(map);
        }

        result = Math.max(result, cnt);
    }

    static int getDist(int x, int y, int ax, int ay) {
        return Math.abs(x - ax) + Math.abs(y - ay);
    }

    static void move(int[][] map) {
        for(int i = 0; i < m; i++) {
            map[n - 1][i] = 0;
        }

        for(int i = n - 1; i > 0; i--) {
            for(int j = 0; j < m; j++) {
                map[i][j] = map[i - 1][j];
            }
        }

        for(int i = 0; i < m; i++) {
            map[0][i] = 0;
        }
    }
}
