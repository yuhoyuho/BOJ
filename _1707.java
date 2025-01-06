package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1707 {
    static int V, E;
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            list = new ArrayList[V + 1];

            for(int j = 0; j <= V; j++) {
                list[j] = new ArrayList<>();
            }

            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int pos1 = Integer.parseInt(st.nextToken());
                int pos2 = Integer.parseInt(st.nextToken());

                list[pos1].add(pos2);
                list[pos2].add(pos1);
            }
            grouping();
        }
    }
    static void grouping() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= V; i++) {
            if(visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();

                for(int j = 0; j < list[now].size(); j++) {
                    if(visited[list[now].get(j)] == visited[now]) {
                        System.out.println("NO");
                        return;
                    }
                    if(visited[list[now].get(j)] == 0) {
                        q.add(list[now].get(j));
                    }

                    if(visited[now] == 1 && visited[list[now].get(j)] == 0) {
                        visited[list[now].get(j)] = 2;
                    }
                    else if(visited[now] == 2 && visited[list[now].get(j)] == 0) {
                        visited[list[now].get(j)] = 1;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}