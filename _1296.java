package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _1296 {
    static int[] arr = new int[4];
    static String love = "LOVE";
    static int max = -1;
    static String win = "";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String Yname = br.readLine();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String Tname = br.readLine();

            for(int j = 0; j < 4; j++) {
                int sum = Yname.length() - Yname.replace(String.valueOf(love.charAt(j)), "").length();
                sum += Tname.length() - Tname.replace(String.valueOf(love.charAt(j)), "").length();

                arr[j] = sum;
            }

            int result = 1;

            for(int j = 0; j < 4; j++) {
                for(int k = (j + 1); k < 4; k++) {
                    result *= (arr[j] + arr[k]);
                }
            }

            if(max == (result % 100) && win != "") {
                String[] arr2 = new String[2];
                arr2[0] = win;
                arr2[1] = Tname;
                Arrays.sort(arr2);
                win = arr2[0];
            }

            if(max < (result % 100)) {
                win = Tname;
                max = result % 100;
            }
        }
        System.out.println(win);
    }
}