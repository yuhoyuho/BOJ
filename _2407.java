package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2407 {
    static int n, m;
    static double result;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        result = 1;
        comb(n, m, 0);
        for(int i : list) {
            result *= i;
        }



        System.out.println(result);
    }


    static void comb(int n, int m, int depth) {
        if(depth == m) {
            return;
        }

        if(n / 2 < m) {
            m = n - m;
        }

        list.add(n);
        comb(n - 1, m, depth + 1);
    }
}
