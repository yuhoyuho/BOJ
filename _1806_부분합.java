package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806_부분합 {
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, min = 100001;
        int f = 0, e = 0;
        while(f <= e && e <= n - 1) {
            if(sum >= s) {
                min = Math.min(min, e - f);
                sum -= arr[f++];
            }
            else {
                sum += arr[e++];
            }
        }

        if(min == 100001) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }
    }
}
