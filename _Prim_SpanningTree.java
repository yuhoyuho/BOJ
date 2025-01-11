package BaekJoon;

import java.util.List;
import java.util.PriorityQueue;

public class _Prim_SpanningTree {
    static int result;
    static List<Node>[] list;
    static boolean[] visited;

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

    public static void main(String[] args) {

    }

    static void prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0)); // 시작점의 비용은 항상 0

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            int end = curNode.end;
            int weight = curNode.weight;

            if(visited[end]) {
                continue;
            }
            visited[end] = true;
            result += weight;

            for(Node nextNode : list[end]) {
                if(!visited[nextNode.end]) {
                    pq.offer(nextNode);
                }
            }
        }
    }
}