package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] start = new int[2];
        int[] end = new int[2];
        int[] circle = new int[3];

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                boolean startPoint = false;
                boolean endPoint = false;

                circle[0] = Integer.parseInt(st.nextToken());
                circle[1] = Integer.parseInt(st.nextToken());
                circle[2] = Integer.parseInt(st.nextToken());

                if(Math.pow(start[0] - circle[0], 2) + Math.pow(start[1] - circle[1], 2) <= Math.pow(circle[2], 2)) {
                    startPoint = true;
                    count++;
                }
                if(Math.pow(end[0] - circle[0], 2) + Math.pow(end[1] - circle[1], 2) <= Math.pow(circle[2], 2)) {
                    endPoint = true;
                    count++;
                }

                if(startPoint == true && endPoint == true) {
                    count -= 2;
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}