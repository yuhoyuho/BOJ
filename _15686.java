package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15686 {
    static int n, m;
    static int[][] map;

    static ArrayList<Point> home;
    static ArrayList<Point> chicken;

    static boolean[] open;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        int cnt = 0;
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {
                    home.add(new Point(i, j));
                }
                else if(map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                    cnt++;
                }
            }
        }

        open = new boolean[cnt];
        result = Integer.MAX_VALUE;

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int s, int cnt) {
        if(cnt == m) {
            int ans = 0;

            for(int i = 0; i < home.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                for(int j = 0; j < chicken.size(); j++) {
                    if(open[j]) {
                        int dist = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);

                        tmp = Math.min(dist, tmp);
                    }
                }

                ans += tmp;
            }

            result = Math.min(ans, result);
            return;
        }

        for(int i = s; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}