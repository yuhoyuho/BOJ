package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _2667 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, count;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        count = 1;
        list = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append('\n');

        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.println(sb);
    }
    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                count++;
                dfs(nx, ny);
            }
        }
    }
}