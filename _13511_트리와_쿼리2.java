package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13511_트리와_쿼리2 {
    static int n, height;
    static int[][] parent;
    static long[][] dist;
    static int[] level;
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i *= 2) {
            height++;
        }

        parent = new int[n + 1][height];
        dist = new long[n + 1][height];
        level = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, dist));
            list.get(e).add(new Node(s, dist));
        }

        init(1, 1, 0);
        parentInit();

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(cmd == 2) {
                int k = Integer.parseInt(st.nextToken());
                sb.append(find(u, v, k)).append('\n');
            }
            else {
                sb.append(getDistance(u, v)).append('\n');
            }
        }
        System.out.println(sb);
    }

    static int find(int u, int v, int k) {
        int lca = LCA(u, v);
        int total = level[u] + level[v] - 2 * level[lca];

        if(k - 1 <= level[u] - level[lca]) {
            return move(u, k - 1);
        }
        else {
            return move(v, total - (k - 1));
        }
    }

    static int LCA(int u, int v) {
        if(level[u] < level[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        for(int i = height - 1; i >= 0; i--) {
            if(level[u] - level[v] >= (1 << i)) {
                u = parent[u][i];
            }
        }

        if(u == v) {
            return u;
        }

        for(int i = height - 1; i >= 0; i--) {
            if(parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    static int move(int node, int k) {
        for(int i = 0; i < height; i++) {
            if(((1 << i) & k) != 0) {
                node = parent[node][i];
            }
        }

        return node;
    }

    static long getDistance(int u, int v) {
        long sum = 0;

        if(level[u] < level[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        // 노드 레벨 맞추기 (맞추는 과정에서 이동하는 거리도 더해줌)
        for(int i = height - 1; i >= 0; i--) {
            if(level[u] - level[v] >= (1 << i)) {
                sum += dist[u][i];
                u = parent[u][i];
            }
        }

        if(u == v) {
            return sum;
        }

        // 두 노드의 레벨을 맞춘 후 LCA로 조상 비교 (이 과정에서 거리도 더해줌)
        for(int i = height - 1; i >= 0; i--) {
            if(parent[u][i] != parent[v][i]) {
                sum += dist[u][i] + dist[v][i];
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        // 조상이 같다면 멈추기 때문에 u, v에서 조상까지의 거리 추가
        sum += dist[u][0] + dist[v][0];

        return sum;
    }

    static void parentInit() {
        for(int i = 1; i < height; i++) {
            for(int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
                dist[j][i] = dist[parent[j][i - 1]][i - 1] + dist[j][i - 1];
            }
        }
    }

    static void init(int c, int l, int p) {
        level[c] = l;
        parent[c][0] = p;

        for(Node next : list.get(c)) {
            if(next.e == p) {
                continue;
            }

            dist[next.e][0] = next.dist; // 1칸 위 정점까지의 거리
            init(next.e, l + 1, c);
        }

    }

    static class Node {
        int e;
        long dist;

        public Node(int e, int dist) {
            this.e = e;
            this.dist = dist;
        }
    }
}
