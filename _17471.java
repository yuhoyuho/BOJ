package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17471 {

    static int n, result;
    static Area[] area;
    static boolean[][] connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        area = new Area[n + 1];
        connected = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            area[i] = new Area(Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++) {
                int conn = Integer.parseInt(st.nextToken());
                connected[i][conn] = true;
                connected[conn][i] = true;
            }
        }

        ArrayList<Integer> A = new ArrayList<>();
        result = Integer.MAX_VALUE;

        comb(1, A);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static boolean isConnected(ArrayList<Integer> A) {
        if(A.isEmpty()) {
            return false;
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        visited[A.get(0)] = true;
        q.offer(A.get(0));

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : A) {
                if(!visited[next] && connected[cur][next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        for(int i : A) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    static void dfs(ArrayList<Integer> A) {
        if(!isConnected(A)) {
            return;
        }

        ArrayList<Integer> B = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(!A.contains(i)) {
                B.add(i);
            }
        }

        if(!isConnected(B)) {
            return;
        }

        int resultA = 0;
        for(int i : A) {
            resultA += area[i].p;
        }

        int resultB = 0;
        for(int i : B) {
            resultB += area[i].p;
        }

        int diff = Math.abs(resultA - resultB);
        result = Math.min(result, diff);
    }

    static void comb(int idx, ArrayList<Integer> A) {
        if(idx == n + 1) {
            if(A.isEmpty() || A.size() == n) {
                return;
            }

            dfs(A);
            return;
        }

        // idx 구역 선택 o
        A.add(idx);
        comb(idx + 1, A);
        A.remove(A.size() - 1);

        // idx 구역 선택 x
        comb(idx + 1, A);
    }

    static class Area {
        int p;

        public Area(int p) {
            this.p = p;
        }
    }
}
