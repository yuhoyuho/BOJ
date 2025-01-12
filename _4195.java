package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _4195 {
    static int[] parent; // 연결을 확인하는 배열
    static int[] connect; // 친구의 수를 세는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            parent = new int[F * 2];
            connect = new int[F * 2];
            int idx = 0;

            for(int i = 0; i < F * 2; i++) {
                parent[i] = i;
                connect[i] = 1;
            }

            for(int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                String f1 = st.nextToken();
                String f2 = st.nextToken();

                if(!map.containsKey(f1)) {
                    map.put(f1, idx);
                    idx++;
                }

                if(!map.containsKey(f2)) {
                    map.put(f2, idx);
                    idx++;
                }
                sb.append(union(map.get(f1), map.get(f2))).append('\n');
            }
        }
        System.out.println(sb);
    }
    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
            connect[x] += connect[y];
        }

        return connect[x];
    }
}