package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _5052_전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for(int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);
            check(arr);
        }
    }

    static void check(String[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1].startsWith(arr[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
