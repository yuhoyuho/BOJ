package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 합승택시요금 {

    static int n, s, a, b;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = Integer.parseInt(br.readLine());
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e =  Integer.parseInt(st.nextToken());
            int cost =  Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, cost));
            list.get(e).add(new Node(s, cost));
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int together = dijkstra(s, i); // 한 정점까지 같이 가는 비용
            int aloneA = dijkstra(i, a);
            int aloneB = dijkstra(i, b);

            result = Math.min(result, together + aloneA + aloneB);
        }

        System.out.println(result);
    }

    static int dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cost > dist[cur.x]) {
                continue;
            }

            for(Node node : list.get(cur.x)) {
                int next = node.x;
                int cost = cur.cost + node.cost;

                if(dist[next] > cost) {
                    dist[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }

        return dist[e];
    }

    static class Node implements Comparable<Node> {
        int x, cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
