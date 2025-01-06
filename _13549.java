package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13549 {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int N, K;
    static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];
        BFS();
        System.out.println(min);
    }

    static void BFS() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if(node.x == K) {
                min = Math.min(min, node.time);
            }
            if(node.x * 2 <= max && !visited[node.x * 2]) {
                q.offer(new Node(node.x * 2, node.time));
            }
            if(node.x + 1 <= max && !visited[node.x + 1]) {
                q.offer(new Node(node.x + 1, node.time + 1));
            }
            if(node.x - 1 >= 0 && !visited[node.x - 1]) {
                q.offer(new Node(node.x - 1, node.time + 1));
            }
        }
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}