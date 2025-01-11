package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1197 {
    static int v, e;
    static int[] parent;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        cost = new int[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Node(start, end, weight));
        }

        int result = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(find(node.start) == find(node.end)) {
                continue;
            }

            union(node.start, node.end);
            result += node.weight;
        }

        System.out.println(result);
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return;
        }

        if(cost[x] < cost[y]) {
            parent[x] = y;
        }
        else {
            parent[y] = x;

            if(cost[x] == cost[y]) {
                cost[x]++;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int start, end, weight;

        Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}