package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea25469 {
    static int n, m, cnt;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new char[n][m];

            for(int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }

            cnt = 0;
            find();
            System.out.println(cnt);
        }
    }

    static void find() {
        for(int i = 0; i < n; i++) {
            boolean flag = true;
            for(int j = 0; j < m; j++) {
                if(map[i][j] == '.') {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt++;
            }
        }

        for(int i = 0; i < m; i++) {
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if(map[j][i] == '.') {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt++;
            }
        }

        if(cnt == n + m) {
            cnt = Math.min(n, m);
        }
    }
}
