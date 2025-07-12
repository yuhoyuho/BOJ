package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1920 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(find(x)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
    static boolean find(int x) {
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == x) {
                return true;
            }
            else if(arr[mid] > x) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return false;
    }
}
