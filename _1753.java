package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753 {
    static int V, E, K;
    static int max = 300000000;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

         V = Integer.parseInt(st.nextToken());
         E = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(br.readLine());

         dist = new int[V + 1];
         visited = new boolean[V + 1];
         a = new ArrayList<>();
         Arrays.fill(dist, max);

         for(int i = 0; i <= V; i++) {
             a.add(new ArrayList<>());
         }

         for(int i = 0; i < E; i++) {
             st = new StringTokenizer(br.readLine());

             int start = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             int weight = Integer.parseInt(st.nextToken());

             a.get(start).add(new Node(end, weight));
         }

         dijkstra(K);
         for(int i = 1; i <= V; i++) {
             if(dist[i] == max) {
                 sb.append("INF\n");
             }
             else {
                 sb.append(dist[i]).append('\n');
             }
         }
        System.out.println(sb);
    }
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
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