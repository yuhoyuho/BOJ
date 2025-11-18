package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2138_전구와_스위치 {
    static int n;
    static char[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[] init = br.readLine().toCharArray();
        char[] initCp = init.clone();
        target = br.readLine().toCharArray();

        int cnt1 = solve(init, false);
        int cnt2 = solve(initCp, true);

        if(cnt1 == -1 && cnt2 == -1) {
            System.out.println(-1);
        }
        else if(cnt1 == -1 && cnt2 != -1) {
            System.out.println(cnt2);
        }
        else if(cnt1 != -1 && cnt2 == -1) {
            System.out.println(cnt1);
        }
        else {
            System.out.println(Math.min(cnt1, cnt2));
        }
    }

    static int solve(char[] arr, boolean on) {
        int cnt = 0;
        if(on) {
            press(arr, 0);
            cnt++;
        }

        for(int i = 1; i < n; i++) {
            if(arr[i - 1] != target[i - 1]) {
                press(arr, i);
                cnt++;
            }
        }

        if(arr[n - 1] != target[n - 1]) {
            return -1;
        }

        return cnt;
    }

    static void press(char[] arr, int start) {
        for(int i = start - 1; i <= start + 1; i++) {
            if(i >= 0 && i < n) {
                arr[i] = (arr[i] == '0' ? '1' : '0');
            }
        }
    }
}
