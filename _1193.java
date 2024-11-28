package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cross_block = 1, block_count = 0;

        while(true) {
            if(N <= cross_block + block_count) {

                if(cross_block % 2 == 1) {
                    System.out.print((cross_block - (N - block_count - 1)) + "/" + (N - block_count));
                    break;
                } else {
                    System.out.println((N - block_count) + "/" + (cross_block - (N - block_count - 1)));
                    break;
                }
            } else {
                block_count += cross_block;
                cross_block++;
            }
        }
    }
}