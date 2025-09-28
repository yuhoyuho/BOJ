package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {
    static int n, cnt;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n];

        recur(0);
        System.out.println(cnt);
    }

    static void recur(int depth) {
        if(depth == n) {
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++) {
            map[depth] = i;

            if(possible(depth)) {
                recur(depth + 1);
            }
        }
    }

    static boolean possible(int col) {
        for(int i = 0; i < col; i++) {
            if(map[col] == map[i]) {
                return false;
            }
            else if(Math.abs(col - i) == Math.abs(map[col] - map[i])) {
                return false;
            }
        }
        return true;
    }
}
