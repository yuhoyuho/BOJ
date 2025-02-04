package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2110 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[n - 1] - arr[0] + 1;

        while(true) {
            if(min >= max) {
                break;
            }

            int mid = (min + max) / 2;

            if(install(mid) < c) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    static int install(int dist) {
        int cnt = 1; // 설치한 공유기의 수
        int before = arr[0]; // 첫번째 집은 무조건 설치한다고 가정

        for(int i = 1; i < arr.length; i++) {
            int now = arr[i];

            if(now - before >= dist){
                cnt++;
                before = now;
            }
        }

        return cnt;
    }
}