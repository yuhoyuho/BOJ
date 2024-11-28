package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int pos = 1;
        String num = br.readLine();

        while(pos <= 30000) {
            String tmp = String.valueOf(pos);
            for(int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) == num.charAt(count)) {
                    count++;
                }
                if(count == num.length()) {
                    System.out.println(pos);
                    return;
                }
            }
            pos++;
        }
    }
}