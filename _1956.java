package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1956 {
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e =  Integer.parseInt(st.nextToken());
        int[][] map = new int[v][v];

        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                if(i != j) {
                    map[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < e; i++) {
            st =  new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            map[start][end] = dist;
        }

        for(int k = 0; k < v; k++) {
            for(int i = 0; i < v; i++) {
                for(int j = 0; j < v; j++) {
                    if(i == j) {
                        continue;
                    }

                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int result = INF;
        for(int i = 0; i < v; i++) {
            for(int j = 0; j < v; j++) {
                if(i == j) {
                    continue;
                }

                if(map[i][j] != INF && map[j][i] != INF) {
                    result = Math.min(result, map[i][j] + map[j][i]);
                }
            }
        }

        System.out.println(result == INF ? -1 : result);
    }
}
