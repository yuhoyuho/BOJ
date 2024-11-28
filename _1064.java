package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] B = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] C = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        if(checkSlope(A, B, C)) {
            System.out.println(-1.0);
            return;
        }

        double[] arr = {dist(A, B), dist(A, C), dist(B, C)};

        Arrays.sort(arr);

        double result = (arr[2] - arr[0]) * 2;

        System.out.println(result);
    }

    private static double dist(int[] A, int[] B) {
        int dx = A[0] - B[0];
        int dy = A[1] - B[1];

        return Math.sqrt(dx * dx + dy * dy);
    }

    private static boolean checkSlope(int[] A, int[] B, int[] C) {
        return ((A[1] - B[1]) * (A[0] - C[0]) == (A[1] - C[1]) * (A[0] - B[0]));
    }
}