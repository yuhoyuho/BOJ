package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _10800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Ball[] ball = new Ball[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            ball[i] = new Ball(i + 1, c, s);
        }

        // 크기 오름차순으로 정렬
        Arrays.sort(ball, new Comparator<Ball>() {
            @Override
            public int compare(Ball o1, Ball o2) {
                return o1.size - o2.size;
            }
        });

        int idx = 0; // 공 번호
        int sum = 0;

        int[] result = new int[n]; // 결과 저장
        int[] color = new int[n + 1]; // color별 누적합 저장

        for(int i = 0; i < n; i++) {
            Ball cur = ball[i];

            while(ball[idx].size < cur.size) {
                sum += ball[idx].size;
                color[ball[idx].color] += ball[idx].size;
                idx++;
            }

            result[cur.id - 1] = sum - color[cur.color];
        }

        for(int i : result) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static class Ball {
        int id, color, size;

        public Ball(int id, int color, int size) {
            this.id = id;
            this.color = color;
            this.size = size;
        }
    }
}