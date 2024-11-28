package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class _1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;

            for(int j = 0; j < N; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if(sum.compareTo(BigInteger.ZERO) == -1) {
                System.out.println("-");
            } else if(sum.compareTo(BigInteger.ZERO) == 1) {
                System.out.println("+");
            } else {
                System.out.println("0");
            }
        }
    }
}