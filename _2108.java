package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2108 {
    static int n, sum;
    static int[] arr;;
    static int[] cnt;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        cnt = new int[8002];

        sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];

            if(arr[i] < 0) {
                cnt[i + 4000]++;
            }
            else {
                cnt[i]++;
            }
        }

        calc(sum);
        System.out.println(sb);
    }

    static void calc(double sum) {
        double avg = Math.round(sum / n);
        double mode = 1;

        int maxIdx = 0;
        int max = 0;
        for(int i = 0; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
            maxIdx = i;
        }


        Arrays.sort(arr);
        double mid = arr[n / 2];
        double range = arr[n - 1] - arr[0];
    }
}
