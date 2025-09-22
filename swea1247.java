package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class swea1247 {

    static ArrayList<Node> list;
    static int[][] arr;
    static int n, min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int num = 1;
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 2][n + 2];
            list = new ArrayList<>();
            visited = new boolean[n + 2];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n + 2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
            }

            for(int i = 0; i < n + 2; i++) {
                for(int j = 0; j < n + 2; j++) {
                    if(i == j || (i == 0 && j == 1) || (i == 1 && j == 0)) {
                        continue;
                    }

                    int d = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);
                    arr[i][j] = d;
                    arr[j][i] = d;
                }
            }

            min = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println("#" + num++ + " " + min);
        }
    }

    static void dfs(int node, int sum, int cnt) {
        if(sum >= min) {
            return;
        }

        if(cnt == n) {
            min = Math.min(min, sum + arr[node][1]);
            return;
        }

        for(int i = 2; i < n + 2; i++) {
            if(!visited[i - 2]) {
                visited[i - 2] = true;
                dfs(i, sum + arr[node][i], cnt + 1);
                visited[i - 2] = false;
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
