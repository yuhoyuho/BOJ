package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17245 {
    static int n;
    static long time, sum, max;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        max = Integer.MIN_VALUE; // 최고 온도 (가장 오래 걸리는 시간)

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
                max = Math.max(max, map[i][j]);
            }
        }

        binarySearch(0, max);
        System.out.println(time);
    }

    static void binarySearch(long start, long end) {
        if(start == 0 && end == 0) {
            time = 0;
            return;
        }

        while(start <= end) {
            long mid = (start + end) / 2;

            if(cooling(mid) >= (sum + 1) / 2) {
                time = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
    }

    static long cooling(long time) {
        long result = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] <= time) {
                    result += map[i][j];
                }
                else {
                    result += time;
                }
            }
        }

        return result;
    }
}
