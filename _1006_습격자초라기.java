package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1006_습격자초라기 {
    static int n, w;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new int[n * 2 + 1]; // 0 : 1, 7 / 1 : 0, 2      -- ( 좌우로 1씩 연관 ) + ( 행으로 +1 )

            int idx = 1;
            for(int k = 0; k < 2; k++) {
                st = new StringTokenizer(br.readLine());
                map[idx++] = Integer.parseInt(st.nextToken());
            }

            // TODO : 인접한 구역 수 파악(2개 인접까지 계산 - 1개 인접 계산 (좌, 우, 하 3개 다 계산해야함))
            // -> w보다 같거나 크다면 cnt++; 인접한거 없으면 cnt++;
            // 인접 구역 = -1이 0과 같거나 작으면 2 * n
            //           +1이 2 * n보다 크면 1
            //           + n이 2 * n보다 크면 -n
            //           - n이 1보다 작으면 +n

        }
    }
}
