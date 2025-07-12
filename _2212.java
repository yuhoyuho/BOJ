package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Integer[] dist = new Integer[n - 1];

        if(k >= n) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i++) {
            dist[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(dist);
        int result = 0;
        for(int i = 0; i < n - k; i++) {
            result += dist[i];
        }

        System.out.println(result);
    }
}