package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11729 {
    static StringBuilder sb = new StringBuilder();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        count = 0;

        move(n, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb);
    }

    static void move(int n, int start, int mid, int to) {
//         n = 원판의 개수
//         start = 출발점
//         mid = 경유지
//         to = 목적지
        count++;

        if(n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        move(n - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        move(n - 1, mid, start, to);
    }
}