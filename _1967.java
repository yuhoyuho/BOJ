package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1967 {
    static ArrayList<ArrayList<Node>> list;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, weight));
            list.get(e).add(new Node(s, weight));
        }

        result = 0;
        for(int i = 1; i <= n; i++) {
            dfs(i, 0);
            visited = new boolean[n + 1];
        }

        System.out.println(result);
    }

    static void dfs(int s, int cnt) {
        visited[s] = true;
        result = Math.max(cnt, result);

        for(Node next : list.get(s)) {
            int start = next.e;
            int weight = next.weight;

            if(!visited[start]) {
                dfs(start, cnt + weight);
            }
        }
    }

    static class Node {
        int e, weight;

        public Node(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }
    }
}