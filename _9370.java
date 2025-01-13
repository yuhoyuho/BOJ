package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _9370 {
    static int n, m, t, s, g, h;
    static int INF = 100000000; // 정수 오버플로우를 고려하지 않아서 자꾸 틀림.
    static ArrayList<ArrayList<Node>> a;
    static boolean[] visited;
    static int[] dist; // 걸린 시간
    static List<Integer> ansList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken()); // 교차로
            m = Integer.parseInt(st.nextToken()); // 도로
            t = Integer.parseInt(st.nextToken()); // 목적지

            visited = new boolean[n + 1];
            dist = new int[n + 1];
            a = new ArrayList<>();
            ansList = new ArrayList<>();

            Arrays.fill(dist, INF); // 최소거리 갱신을 위해 큰 값으로 초기화

            // 점 연결을 위한 배열 할당
            for(int i = 0; i <= n; i++) {
                a.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 출발점
            g = Integer.parseInt(st.nextToken()); // 지나야하는 점 1
            h = Integer.parseInt(st.nextToken()); // 지나야하는 점 2

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if((start == g && end == h) || (start == h && end == g)) {
                    a.get(start).add(new Node(end, weight * 2 - 1));
                    a.get(end).add(new Node(start, weight * 2 - 1));
                }
                else {
                    a.get(start).add(new Node(end, weight * 2));
                    a.get(end).add(new Node(start, weight * 2));
                }
            }

            for(int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                dijkstra(s);

                if(dist[x] % 2 == 1) {
                    ansList.add(x);
                }
            }
            Collections.sort(ansList);
            for(int i : ansList) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
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
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}