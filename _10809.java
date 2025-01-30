package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(arr[c - 'a'] == -1) {
                arr[c - 'a'] = i;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}