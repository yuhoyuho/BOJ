package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1761_정점들의_거리 {
    static int n, m, height;
    static List<List<Node>> list = new ArrayList<>();
    static int[] level, dist;
    static int[][] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i *= 2) {
            height++;
        }

        parent = new int[n + 1][height];
        level = new int[n + 1];
        dist = new int[n + 1]; // 루트에서 n번까지의 거리

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, dist));
            list.get(b).add(new Node(a, dist));
        }

        init(1, 1, 0, 0);
        parentInit();

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getDistance(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static int getDistance(int a, int b) {
        return dist[a] + dist[b] - 2 * dist[LCA(a, b)];
    }

    static int LCA(int a, int b) {
        int ah = level[a];
        int bh = level[b];

        // ah가 항상 크다고 가정
        if(ah < bh) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        for(int i = height - 1; i >= 0; i--) {
            // level의 차이만큼 이동
            if(Math.pow(2, i) <= level[a] - level[b]) {
                a = parent[a][i];
            }
        }

        if(a == b) {
            return a;
        }

        for(int i = height - 1; i >= 0; i--) {
            if(parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }

    static void parentInit() {
        for(int i = 1; i < height; i++) {
            for(int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    static void init(int c, int l, int p, int d) {
        level[c] = l;
        parent[c][0] = p;
        dist[c] = d;

        for(Node next : list.get(c)) {
            if(next.num == p) {
                continue;
            }
            init(next.num, l + 1, c, next.dist + d);
        }
    }

    static class Node {
        int num, dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
