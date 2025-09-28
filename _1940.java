package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] materials = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);
        int f = 0, e = n - 1, cnt = 0;
        for(int i = 0; i < n; i++) {
            if(materials[i] > m) {
                e = i - 1;
                break;
            }
        }

        while(e > f) {
            if(materials[f] + materials[e] == m) {
                cnt++;
                f++;
                e--;
            }
            else if(materials[f] + materials[e] < m) {
                f++;
            }
            else {
                e--;
            }
        }
        System.out.println(cnt);
    }
}
