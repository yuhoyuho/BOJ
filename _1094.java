package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1094 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stick = 64;
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        int tmp = 0;

        while(true) {
            if(X == 64) {
                count++;
                break;
            }

            stick /= 2;

            if(stick <= X) {
                tmp = stick;
                count++;

                if(tmp == X) {
                    break;
                }

                X -= stick;
            }
        }
        System.out.println(count);
    }
}