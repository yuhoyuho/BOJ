package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2748 {
    private static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];

        for(int i = 0; i < N + 1; i++) {
            arr[i] = -1;
        }

        arr[0] = 0;
        arr[1] = 1;

        System.out.println(fibonacci(N));
    }

    public static long fibonacci(int n) {
        if(arr[n] == -1) {
            arr[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return arr[n];
    }
}