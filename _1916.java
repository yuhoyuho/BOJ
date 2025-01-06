package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916 {
    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        a = new ArrayList<>();
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.point;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : a.get(cur)) {
                    if(!visited[node.point] && dist[node.point] > dist[cur] + node.weight) {
                        dist[node.point] = dist[cur] + node.weight;
                        pq.add(new Node(node.point, dist[node.point]));
                    }
                }
            }
        }
        return dist[end];
    }
}

class Node implements Comparable<Node> {
    int point;
    int weight;

    Node(int point, int weight) {
        this.point = point;
        this.weight = weight;
    }

    public int compareTo(Node o) {
        return weight - o.weight;
    }
}