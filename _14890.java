package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14890 {
    static int n, l, cnt;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        row();
        col();
        System.out.println(cnt);
    }

    static void row() {
        int std = 0;
        while(std++ < n) {

            boolean[] visited = new boolean[n];

            for(int i = 0; i < n - 1; i++) {
                int diff = map[std][i] - map[std][i + 1];

                if(diff > 1 || diff < -1) { // 경사로 설치가 불가능한 경우
                    continue;
                }
                else { // 경사로 설치가 가능한 경우
                    if(diff > 0) {
                        for(int j = i + 1; j < i + 1 + l; j++) {
                            if(j > n - 1) {
                                break;
                            }
                            if(visited[i] || visited[j]) {
                                break;
                            }
                            visited[i] = true;
                            visited[j] = true;
                        }
                    }
                    else if(diff < 0) {
                        if(i - l < 0) {
                            break;
                        }


                        for(int j = i - l; j < i; j++) {

                        }
                    }
                }
            }
            cnt++;
        }
    }

    static void col() {

    }
}
