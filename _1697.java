package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697 {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.println(0);
        }
        else {
            bfs(N);
        }
    }

    static void bfs(int pos) {
        Queue<Integer> q = new LinkedList<>();
        q.add(pos);
        visited[pos] = 1;

        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int i = 0; i < 3; i++) {
                int next;

                if(i == 0) {
                    next = tmp - 1;
                }
                else if(i == 1) {
                    next = tmp + 1;
                }
                else {
                    next = tmp * 2;
                }

                if(next == K) {
                    System.out.println(visited[tmp]);
                    return;
                }

                if(next >= 0 && next < visited.length && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[tmp] + 1;
                }
            }
        }
    }
}