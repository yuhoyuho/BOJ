package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13016_흑염룡 {
    static int n;
    static int[] distS, distE;
    static List<List<Node>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        distS = new int[n + 1];
        distE = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, d));
            list.get(e).add(new Node(s, d));
        }

        int[] tmp = new int[n + 1];
        bfs(1, tmp); // 트리의 두 개의 끝 점 중 하나 찾기
        int s = 0;
        for(int i = 1; i <= n; i++) {
            if(tmp[i] > tmp[s]) {
                s = i;
            }
        }

        bfs(s, distS); // 다른 한 점 찾기
        int e = s;
        for(int i = 1; i <= n; i++) {
            if(distS[i] > distS[e]) {
                e = i;
            }
        }

        bfs(e, distE);
        for(int i = 1; i <= n; i++) {
            sb.append(Math.max(distS[i], distE[i])).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int x, int[] dist) {
        boolean[] visited = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, 0));
        dist[x] = 0;
        visited[x] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(Node next : list.get(cur.e)) {
                if(!visited[next.e]) {
                    visited[next.e] = true;
                    dist[next.e] = cur.dist + next.dist;
                    q.offer(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
    static class Node {
        int e, dist;

        public Node(int e, int dist) {
            this.e = e;
            this.dist = dist;
        }
    }
}
