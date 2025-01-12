package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1167 {
    static int V, node;
    static int result = Integer.MIN_VALUE;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[V + 1];

        for(int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            while(true) {
                int end = Integer.parseInt(st.nextToken());

                if(end == - 1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());

                list.get(idx).add(new Node(end, weight));
            }
        }

        dfs(1,0);

        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(result);
    }
    static void dfs(int x, int weight) {
        if(weight > result) {
            result = weight;
            node = x;
        }

        visited[x] = true;

        for(int i = 0; i < list.get(x).size(); i++) {
            Node node = list.get(x).get(i);

            if(!visited[node.end]) {
                dfs(node.end, node.weight + weight);
            }
        }
    }
    static class Node {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}