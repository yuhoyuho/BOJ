package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11779 {
    static int N, M;
    static int[] dist;
    static boolean[] visited;
    static int[] path;
    static ArrayList<ArrayList<Node>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        a = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        path = new int[N + 1];

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

        sb.append(dijkstra(start, end)).append('\n');

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        int count = 0;

        while(path[end] != 0) {
            count++;
            stack.push(path[end]);
            end = path[end];
        }
        sb.append(count + 1).append('\n');

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        boolean[] visited = new boolean[N + 1];

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : a.get(cur)) {
                    if(!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        path[node.end] = cur;

                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
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