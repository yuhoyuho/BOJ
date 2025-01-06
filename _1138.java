package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1138 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N + 1];
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N + 1; i++) {
            int k = 1;

            while(true) {
                if(arr[i] == 0 && height[k] == 0) {
                    height[k] = i;
                    break;
                }
                else if(height[k] == 0) {
                    arr[i]--;
                }
                k++;
            }
        }

        for(int i = 1; i < N + 1; i++) {
            System.out.print(height[i] + " ");
        }
    }
}