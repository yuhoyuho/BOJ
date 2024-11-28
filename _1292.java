package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j <= i; j++) {
                list.add(i + 1);
            }
        }

        for(int i = A - 1; i < B; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}