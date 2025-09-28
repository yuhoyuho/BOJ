package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();
        int[] min = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            min[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[4];

        for (int i = 0; i < p; i++) {
            add(dna[i], cnt);
        }

        int result = 0;
        if (check(cnt, min)) result++;

        // 슬라이딩 윈도우
        for (int i = p; i < s; i++) {
            add(dna[i], cnt);
            remove(dna[i - p], cnt);
            if (check(cnt, min)) result++;
        }

        System.out.println(result);
    }

    static void add(char c, int[] cnt) {
        if (c == 'A') cnt[0]++;
        else if (c == 'C') cnt[1]++;
        else if (c == 'G') cnt[2]++;
        else if (c == 'T') cnt[3]++;
    }

    static void remove(char c, int[] cnt) {
        if (c == 'A') cnt[0]--;
        else if (c == 'C') cnt[1]--;
        else if (c == 'G') cnt[2]--;
        else if (c == 'T') cnt[3]--;
    }

    static boolean check(int[] cnt, int[] min) {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] < min[i]) return false;
        }
        return true;
    }
}
