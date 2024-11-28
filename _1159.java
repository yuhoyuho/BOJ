package BaekJoon;

import java.util.Scanner;

public class _1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[26];

        for(int i = 0; i < N; i++) {
            String name = sc.next();
            int ch = name.charAt(0) - 97; // 'a' ASCII CODE = 97
            arr[ch]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 5) {
                sb.append((char)(i + 97));
            }
        }

        if(sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb);
        }

    }
}