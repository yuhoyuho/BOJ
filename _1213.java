package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            alphabet[str.charAt(i) - 'A']++;
        }

        int odd = 0;
        int index = 0;

        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] != 0 && alphabet[i] % 2 == 1) {
                odd++;
                index = i;
            }

            if(odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        for(int i = 0; i < alphabet.length; i++) {
            for(int j = 0; j < alphabet[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }
        String palindrome = sb.toString();

        if(odd == 1) {
            palindrome += (char)(index + 'A');
        }

        palindrome += sb.reverse().toString();

        System.out.println(palindrome);
    }
}