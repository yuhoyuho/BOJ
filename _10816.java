package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(map.getOrDefault(num, 0) + " ");
        }

        System.out.println(sb);
    }
}