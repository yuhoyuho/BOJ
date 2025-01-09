package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(cmd == 0) {
                union(x, y);
            }
            else if(cmd == 1) {
                sb.append(sameRoot(x, y) ? "YES" : "NO").append('\n');
            }
            else {
                continue;
            }
        }
        System.out.println(sb);
    }
    static int find(int x) {
        if(x != parent[x]) {
            return parent[x] = find(parent[x]);
        }

        return x;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) {
                parent[y] = x;
            }
            else {
                parent[x] = y;
            }
        }
    }

    static boolean sameRoot(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        }

        return false;
    }
}