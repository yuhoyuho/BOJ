package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1011 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            cal(start, end);
        }
        System.out.println(sb);
    }
    static void cal(int start, int end) {
        int dist = end - start;
        int max = (int)Math.sqrt(dist);

        if(max == Math.sqrt(dist)) {
            sb.append(max * 2 - 1).append('\n');
        }
        else if(dist <= max * max + max) {
            sb.append(max * 2).append('\n');
        }
        else {
            sb.append(max * 2 + 1).append('\n');
        }
    }
}