package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1019 {
    static int[] count = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        count(1, n, 1);

        for(int idx : count) {
            sb.append(idx).append(" ");
        }

        System.out.println(sb);
    }

    static void count(int start, int end, int point) {
        // point : 자리수
        while(start <= end) {
            while(start % 10 != 0 && start <= end) {
                calc(start, point);
                start++;
            }

            while(end % 10 != 9 && start <= end) {
                calc(end, point);
                end--;
            }

            if(start > end) {
                break;
            }

            start /= 10;
            end /= 10;
            for(int i = 0; i < 10; i++) {
                count[i] += (end - start + 1) * point;
            }
            point *= 10;
        }
    }

    static void calc(int num, int point) {
        while(num > 0) {
            count[num % 10] += point;
            num /= 10;
        }
    }
}