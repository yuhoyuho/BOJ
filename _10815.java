package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10815 {
    static int[] card;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        card = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(binary(num) + " ");
        }

        System.out.println(sb);
    }

    static int binary(int num) {
        int left = 0;
        int right = n - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(card[mid] == num) {
                return 1;
            }
            else if(card[mid] > num) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return 0;
    }
}