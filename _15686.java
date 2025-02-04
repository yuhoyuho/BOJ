package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _15686 {
    static int r, c;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][r];
        int count = 0;

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < r; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    count++;
                }
            }
        }

        Integer[] chicken = new Integer[count];
        int idx = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < r; j++) {
                if(map[i][j] == 2) {
                    chicken[idx] = find(i, j);
                    idx++;
                }
            }
        }

        Arrays.sort(chicken, Collections.reverseOrder());

        int result = 0;
        for(int i = count - c; i < count; i++) {
            result += chicken[i];
        }

        System.out.println(result);
    }

    static int find(int x, int y) {
        int result = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < r; j++) {
                if(map[i][j] == 1) {
                    result += Math.abs(i - x) + Math.abs(j - y);
                }
            }
        }

        return result;
    }
}
