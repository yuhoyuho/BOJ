package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1238 {
    static int N, M, X;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> origin, reverse;
    static int max = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        origin = new ArrayList<>();
        reverse = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            origin.add(new ArrayList<>());
            reverse.add (new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            origin.get(start).add(new Node(end, weight));
            reverse.get(end).add(new Node(start, weight));
        }
        int[] origin_dist = dijkstra(origin);
        int[] reverse_dist = dijkstra(reverse);

        int result = 0;
        for(int i = 1; i <= N; i++) {
            result = Math.max(result, origin_dist[i] + reverse_dist[i]);
        }
        System.out.println(result);
    }

    static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, max);
        dist[X] = 0;

        pq.offer(new Node(X, 0));

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
        return dist;
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