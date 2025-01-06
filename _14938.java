package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14938 {
    static int N, M, R;
    static int[] dist;
    static int[] item;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //5
        M = Integer.parseInt(st.nextToken()); // 5
        R = Integer.parseInt(st.nextToken()); // 4

        dist = new int[N + 1];
        item = new int[N + 1];
        visited = new boolean[N + 1];
        a = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, weight));
            a.get(end).add(new Node(start, weight));
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            result = Math.max(result, dijkstra(i));
        }
        System.out.println(result);
    }

    static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // MAX_VALUE 값으로 초기화해야 item[i]를 더할 때 필터링 가능
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
        int count = 0;

        for(int i = 1; i <= N; i++) {
            if(dist[i] <= M) {
                count += item[i];
            }
        }

        return count;
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}