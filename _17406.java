package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17406 {
    static int n, m, k, result;
    static int[][] map;
    static int[][] copyMap;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        copyMap = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copyMap[i][j] = map[i][j];
            }
        }
        list = new ArrayList<>();
        for(int i = 0; i <= k; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list.get(i).add(r);
            list.get(i).add(c);
            list.get(i).add(s);
        }

        result = Integer.MAX_VALUE;
        ArrayList<Integer> A = new ArrayList<>();
        visited = new boolean[k];

        perm(0, A);

        System.out.println(result);
    }

    static void dfs(ArrayList<Integer> A) {
        for(int i = 0; i < k; i++) {
            int r = list.get(A.get(i)).get(0);
            int c = list.get(A.get(i)).get(1);
            int s = list.get(A.get(i)).get(2);

            rotate(r, c, s);
        }

        for(int i = 1; i <= n; i++) {
            int rowCnt = 0;

            for(int j = 1; j <= m; j++) {
                rowCnt += map[i][j];
            }

            result = Math.min(result, rowCnt);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    static void perm(int cnt, ArrayList<Integer> A) {
        if(cnt == k) {
            dfs(A);
            return;
        }

        for(int i = 0; i < k; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            A.add(i);
            perm(cnt + 1, A);
            A.remove(A.size() - 1);
            visited[i] = false;
        }
    }

    static void rotate(int r, int c, int s) {

        for(int i = s; i > 0; i--) {
            int start = map[r - i][c - i];

            // up
            for(int j = r - i + 1; j <= r + i; j++) {
                map[j - 1][c - i] = map[j][c - i];
            }

            // left
            for(int j = c - i + 1; j <= c + i; j++) {
                map[r + i][j - 1] = map[r + i][j];
            }

            // down
            for(int j = r + i - 1; j >= r - i; j--) {
                map[j + 1][c + i] = map[j][c + i];
            }

            // right
            for(int j = c + i - 1; j >= c - i + 1; j--) {
                map[r - i][j + 1] = map[r - i][j];
            }

            map[r - i][c - i + 1] = start;
        }
    }
}
