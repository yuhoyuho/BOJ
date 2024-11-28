package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1049 {
    static int N, M, pack = Integer.MAX_VALUE, piece = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        if(piece * 6 <= pack) {
            sum += N * piece;
        } else {
            sum = (N / 6) * pack;

            if((N % 6) * piece <= pack) {
                sum += (N % 6) * piece;
            } else {
                sum += pack;
            }
        }
        System.out.println(sum);
    }
}