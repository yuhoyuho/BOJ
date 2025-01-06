package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for(int i : sorted) {
            if(!rankMap.containsKey(i)) {
                rankMap.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : origin) {
            int ranking = rankMap.get(i);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}