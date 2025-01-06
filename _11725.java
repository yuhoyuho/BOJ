package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] parent = new int [N + 1];
        ArrayList<Integer>[] arr = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[N + 1];

        StringTokenizer st;
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : arr[cur]) {
                if(visited[next]) {
                    continue;
                }

                visited[next] = true;
                q.add(next);
                parent[next] = cur;
            }
        }

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
}