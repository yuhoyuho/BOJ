package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 666;
        int count = 1;
        int N = Integer.parseInt(br.readLine());

        while(count != N) {
            num++;

            if(String.valueOf(num).contains("666")) {
                count++;
            }
        }

        System.out.println(num);
    }
}