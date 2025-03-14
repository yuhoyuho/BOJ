package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2437 {
    static int[] weight; // 추의 무게 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        weight = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight); // 낮은 무게 순으로 정렬

        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(sum + 1 < weight[i]) {
                break;
            }
            sum += weight[i];
        }
        System.out.println(sum + 1);
    }
}