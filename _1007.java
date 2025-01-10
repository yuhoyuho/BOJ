package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1007 {
    static int N;
    static int[][] point;
    static boolean[] visited;

    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            point = new int[N][2];
            visited = new boolean[N];
            result = Double.MAX_VALUE;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                point[i][0] = Integer.parseInt(st.nextToken());
                point[i][1] = Integer.parseInt(st.nextToken());
            }

            combi(0, 0);
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    static void combi(int count, int start) {
        if(count == N / 2) {
            calculate();
            return;
        }

        for(int i = start; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(count + 1, i + 1);

                visited[i] = false;
            }
        }
    }
    static void calculate() {
        long x = 0;
        long y = 0;

        for(int i = 0; i < N; i++) {
            if(visited[i]) {
                x += point[i][0];
                y += point[i][1];
            }
            else {
                x -= point[i][0];
                y -= point[i][1];
            }
        }

        double vector = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        result = Math.min(result, vector);
    }
}