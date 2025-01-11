package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _Dijkstra_Algorithm {
    static int V, E, start;
    static ArrayList<ArrayList<Node>> graph;

    // 도착지점의 index와 그 비용을 담고 있는 클래스
    // comparable을 구현하여 항상 최소비용을 가진 노드를 선택하도록 오버라이딩 해준다.
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for(int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            // Ex) S = 5, E = 1, W = 2 라면,
            // '5(S)번 노드에서 1(E)번 노드로 가는 비용은 2(W)이다.' 라는 의미이다.
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph.get(S).add(new Node(E, W));
        }

        // dist 배열을 Integer.MAX_VALUE로 초기화한다.
        int[] dist = new int[V + 1];
        for(int i = 0; i < V + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 시작점을 큐에 넣는다.

        // 큐가 빌 때까지, 다익스트라 알고리즘을 실행한다.
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            if(dist[curNode.end] < curNode.weight) {
                continue;
            }

            for(int i = 0; i < graph.get(curNode.end).size(); i++) {
                Node nextNode = graph.get(curNode.end).get(i);

                // 만약 dist[다음 노드의 인덱스](= 해당 노드까지의 비용) 가 현재까지의 비용 + 다음 노드까지의 비용
                // 보다 크다면 dist[nextNode.end]를 최소값으로 갱신해준다.
                // 아래 if문이 참이라면 부등호 오른쪽에 있는 식은 항상 최솟값이기 때문이다.
                if(dist[nextNode.end] > dist[curNode.end] + nextNode.weight) {
                    dist[nextNode.end] = dist[curNode.end] + nextNode.weight;

                    // 그 후 그 지점을 다시 큐에 넣고 그 다음 노드들을 탐색한다.
                    // 다익스트라 알고리즘으로 인해 현재까지의 비용은 반드시 최소이기 때문이다.
                    pq.offer(new Node(nextNode.end, dist[nextNode.end]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}