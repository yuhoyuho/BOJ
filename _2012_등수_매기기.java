package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2012_등수_매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int rank = Integer.parseInt(br.readLine());
            arr[i] = rank;
        }

        Arrays.sort(arr);

        long result = 0;
        for(int i = 0; i < n; i++) {
            result += Math.abs(i + 1 - arr[i]);
        }

        System.out.println(result);
    }
}
