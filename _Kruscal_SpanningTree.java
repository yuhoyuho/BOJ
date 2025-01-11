package BaekJoon;

import java.util.PriorityQueue;
import java.util.Queue;

public class _Kruscal_SpanningTree {

    static int N;
    // 유니온 파인드로 사이클을 확인
    static int[] parent;
    static int[][] graph;

    static class Node implements Comparable<Node> {
        int start, end, cost;

        Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        // cost(간선의 비용)를 기준으로 오름차순 정렬
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) {
        parent = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        // 간선의 비용이 낮은 순으로 뽑아야 하기 때문에
        // PriorityQueue로 구현
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < graph.length; i++) {
            int start = graph[i][0]; // 시작 노드
            int end = graph[i][1]; // 끝 노드
            int cost = graph[i][2]; // 간선의 비용

            // 큐에 추가 (compareTo 메소드를 오버라이딩 했기 때문에
            // 비용을 기준으로 오름차순 정렬이 보장됨.
            // (= 큐에서 첫 번째 요소를 꺼낼 때 항상 간선의 비용이 최소)
            pq.offer(new Node(start, end, cost));
        }

        int size = pq.size();
        int result = 0;

        // 간선을 비용이 작은 순서로 하나씩 확인
        for(int i = 0; i < size; i++) {
            Node curNode = pq.poll();

            int px = find(curNode.start);
            int py = find(curNode.end);

            // 사이클이 발생하지 않는 경우, 간선의 비용을 result에 추가
            if(!isSame(px, py)) {
                result += curNode.cost;
                union(px, py); // 두 점에 대해 합집합 연산 수행
            }
        }
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

        if(x < y) {
            parent[y] = x;
        }
        else {
            parent[x] = y;
        }
    }

    static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }

        return false;
    }
}