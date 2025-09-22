package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4012 {

    static int[][] table;
    static boolean[] visited;
    static int n;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int num = 1;

        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            table = new int[n][n];
            visited = new boolean[n];
            result = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0, 0);
            System.out.println("#" + num++ + " " + result);
        }
    }

    static int cal() {
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(visited[i] && visited[j]) {
                    x += table[i][j];
                }
                else if(!visited[i] && !visited[j]){
                    y += table[i][j];
                }
            }
        }
        return Math.abs(x - y);
    }

    static void comb(int idx, int cnt) {
        if(cnt == n / 2) {
            result = Math.min(result, cal());
            return;
        }

        for(int i = idx; i < n; i++) {
            visited[i] = true;
            comb(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
}
