package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12015 {
    static int[] arr;
    static int[] LIS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int idx = 1;

        for(int i = 1; i < N; i++) {
            int value = arr[i];

            if(value > LIS[idx - 1]) {
                LIS[idx] = value;
                idx++;
            }
            else {
                int low = 0;
                int high = idx;

                while(low < high) {
                    int mid = (low + high) / 2;

                    if(LIS[mid] < value) {
                        low = mid + 1;
                    }
                    else {
                        high = mid;
                    }
                }

                LIS[low] = value;
            }
        }
        System.out.println(idx);
    }
}