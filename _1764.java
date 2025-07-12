package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        String[] db = new String[n];
        HashSet<String> b = new HashSet<>();
        for(int i = 0; i < n; i++) {
            db[i] = br.readLine();
        }

        Arrays.sort(db);

        for(int i = 0; i < m; i++) {
            b.add(br.readLine());
        }

        for(int i = 0; i < n; i++) {
            if(b.contains(db[i])) {
                cnt++;
                sb.append(db[i]).append('\n');
            }
        }

        System.out.println(cnt + "\n" + sb);
    }
}
