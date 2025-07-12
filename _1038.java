package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _1038 {
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(n < 10) {
            System.out.println(n);
        }
        else if(n > 1023) {
            System.out.println(-1);
        }
        else {
            for(int i = 0; i < 10; i++) {
                dfs(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    static void dfs(long n, int cnt) {
        if(cnt > 10) {
            return;
        }

        list.add(n);
        for(int i = 0; i < n % 10; i++) {
            dfs(n * 10 + i, cnt + 1);
        }
    }
}
