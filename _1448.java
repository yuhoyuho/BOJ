package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int result = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i = arr.length - 1; i >= 2; i --) {
            if(arr[i] < arr[i - 1] + arr[i - 2]) {
                int tmp = result;
                result = arr[i] + arr[i - 1] + arr[i - 2];
                result = Math.max(tmp, result);
            }
        }
        if(result == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
}