package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for(int i = 0; i < s.length; i++) {
            int temp = 0;
            String[] addtion = s[i].split("\\+");

            for(int j = 0; j < addtion.length; j++) {
                temp += Integer.parseInt(addtion[j]);
            }

            if(sum == Integer.MAX_VALUE) {
                sum = temp;
            }
            else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}