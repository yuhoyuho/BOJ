package BaekJoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1270 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            System.gc();
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int max = 0;
            long idx = 0;
            Map<Long, Integer> map = new HashMap<>();

            for(int i = 0; i < T; i++) {
                long K = Long.parseLong(st.nextToken());
                map.put(K, map.getOrDefault(K, 0) + 1);
                if(map.get(K) > max) {
                    max = map.get(K);
                    idx = K;
                }
            }
            if(max > (double)T / 2) {
                sb.append(idx + "\n");
            }
            else {
                sb.append("SYJKGW").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}