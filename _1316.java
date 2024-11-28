package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1316 {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++) {
            if(check()) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check() throws IOException{
        boolean[] checker = new boolean[26];

        int prev = 0;
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            int now = s.charAt(i);

            if(now != prev) {
                if(!checker[now - 'a']) {
                    checker[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}