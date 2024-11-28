package BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class _1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger N = sc.nextBigInteger();
        BigInteger M = sc.nextBigInteger();

        System.out.println(N.divide(M) + "\n" + N.remainder(M));
    }
}