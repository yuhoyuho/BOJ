package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1072 {
    private static long X;
    private static long Y;
    private static int winning;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        winning = (int)((Y * 100) / X);

        if(winning >= 99) {
            System.out.println(-1);
            return;
        }

        int left = 0;
        int right = 1000000000;
        int count = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            int z = (int)(((Y + mid) * 100) / (X + mid));

            if(winning >= z) {
                left = mid + 1;
                count = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        System.out.println(count);
    }
}