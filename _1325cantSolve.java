package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1325cantSolve {
    static int V, E;
    static ArrayList<Integer>[] list;
    static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()) {
                int pos = q.poll();

                for(int j = 0; j < list[pos].size(); j++) {

                }
            }
        }
    }
}
