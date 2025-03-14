package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1068 {
    static int[] parent;
    static boolean[] visited;
    static int cnt, del;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == -1) {
                root = i;
            }
            else {
                list.get(i).add(x);
                list.get(x).add(i);
            }
        }

        del = Integer.parseInt(br.readLine());
        if(del == root) {
            System.out.println(0);
            return;
        }
        else {
            dfs(root);
        }
        System.out.println(cnt);
    }

    static void dfs(int x) {
        visited[x] = true;
        int node = 0;

        for(int i : list.get(x)) {
            if(i != del && !visited[i]) {
                node++;
                dfs(i);
            }
        }

        if(node == 0) {
            cnt++;
        }
    }
}