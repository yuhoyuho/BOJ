package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11437_LCA {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] parent, level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        level = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        init(1, 1, 0);
        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static int LCA(int a, int b) {
        while(level[a] > level[b]) {
            a = parent[a];
        }

        while(level[b] > level[a]) {
            b = parent[b];
        }

        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void init(int c, int l, int p) { // cur, level, parent
        parent[c] = p;
        level[c] = l;

        for(int node : list.get(c)) {
            if(node == p) {
                continue;
            }

            init(node, l + 1, c);
        }
    }
}
