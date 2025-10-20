package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"a", "e", "i", "o", "u"};
        while(true) {
            String s = br.readLine().toLowerCase();
            if(s.equals("#")) {
                break;
            }
            int cnt = 0;

            for(int i = 0; i < s.length(); i++) {
                for(int j = 0; j < 5; j++) {
                    if(s.charAt(i) == arr[j].charAt(0)) {
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }
}
