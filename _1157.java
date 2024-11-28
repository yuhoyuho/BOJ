package BaekJoon;
import java.util.Scanner;
import java.util.Arrays;

public class _1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        s = s.toLowerCase();
        int[] arr = new int[26];

        // 대문자 -> 65 ~ 90 / 소문자 -> 97 ~ 122 (ASCII CODE)

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                arr[s.charAt(i) - 'A']++;
            } else {
                arr[s.charAt(i) - 'a']++;
            }
        }

        int max = -1;
        char ch = '?';

        for(int i = 0; i < 26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                ch = (char)(i + 65);
            } else if(arr[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);

    }
}