package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1504 {
    static int N, E;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> a;
    static final int max = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, max);

        for(int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, weight));
            a.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int pos1 = Integer.parseInt(st.nextToken());
        int pos2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        int result2 = 0;

        result1 += dijkstra(1, pos1);
        result1 += dijkstra(pos1, pos2);
        result1 += dijkstra(pos2, N);

        result2 += dijkstra(1, pos2);
        result2 += dijkstra(pos2, pos1);
        result2 += dijkstra(pos1, N);

        int ans = 0;

        if(result1 >= max || result2 >= max) {
            ans = -1;
        }
        else {
            ans = Math.min(result1, result2);
        }
        System.out.println(ans);
    }

    static int dijkstra (int start, int end) {
        Arrays.fill(dist, max);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Node(start, 0));
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
        return dist[end];
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