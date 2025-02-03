package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17472 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] parent;
    static int count;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, count);
                    count++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) {
                    bfs(i, j,map[i][j]);
                }
            }
        }

        count--;
        parent = new int[count];

        for(int i = 1; i < count; i++) {
            parent[i] = i;
        }

        int result = kruscal();

        System.out.println(result == 0 ? -1 : result);
    }

    static void dfs(int x, int y, int num) { // 섬 번호 붙이기
        visited[x][y] = true;
        map[x][y] = num;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx, ny, num);
                }
            }
        }
    }

    static void bfs(int x, int y, int num) { // 다리 놓기
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];

        for(int i = 0; i < 4; i++) {
            q.offer(new int[] {x, y, 0});
            visited[x][y] = true;

            while(!q.isEmpty()) {
                int[] cur = q.poll();

                int cx = cur[0];
                int cy = cur[1];
                int cnt = cur[2];

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }

                if(map[nx][ny] != num) {
                    if(map[nx][ny] != 0) { // 다른 섬을 만난 경우
                        int ix = num - 1;
                        int iy = map[nx][ny] - 1;

                        if(cnt > 1) {
                            pq.offer(new Node(ix, iy, cnt));
                            break;
                        }
                    }
                    else {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny, cnt + 1});
                    }
                }
            }
            q.clear();
        }
    }

    static int kruscal() { // MST - 크루스칼 알고리즘
        int result = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            int x = cur.x;
            int y = cur.y;

            if(find(x) != find(y)) {
                result += cur.cost;
                union(x, y);
            }
        }

        for(int i = 2; i < count; i++) {
            if(parent[1] != find(parent[i])) {
                return 0;
            }
        }

        return result;
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) {
            parent[y] = x;
        }
        else {
            parent[x] = y;
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}