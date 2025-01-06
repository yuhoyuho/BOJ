package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _18352 {
    static int N, M, X, K;
    static boolean[] visited;
    static int[] dist;
    static int max = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, max);
        a = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, 1));
        }
        dijkstra(X);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if(sb.length() == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(dist, max);
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : a.get(cur)) {
                    if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;

                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}