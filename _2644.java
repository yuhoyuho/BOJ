package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2644 {
    static int n, x, y, cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] relations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        relations = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            relations[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            relations[p].add(s);
            relations[s].add(p);
        }

        cnt = -1;
        dfs(x, y, 0);
        System.out.println(cnt);
    }

    static void dfs(int s, int e, int depth) {
        if(s == e) {
            cnt = depth;
            return;
        }

        visited[s] = true;
        for(int i = 0; i < relations[s].size(); i++) {
            int next = relations[s].get(i);

            if(!visited[next]) {
                dfs(next, e, depth + 1);
            }
        }
    }

    static class Relation {
        int x, y;

        public Relation(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
