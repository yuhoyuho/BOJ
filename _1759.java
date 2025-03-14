package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1759 {
    static int L, C;
    static char[] list;
    static char[] pw;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        list =new char[C];
        pw = new char[L];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < C; i++) {
            list[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(list);
        makePW(0, 0);

        System.out.println(sb);
    }

    static void makePW(int start, int cnt) {
        if(cnt == L) {
            if(isValid()) {
                for(char c : pw) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i = start; i < C; i++) {
            pw[cnt] = list[i];

            makePW(i + 1, cnt + 1);
        }
    }

    static boolean isValid() {
        int consonant = 0;
        int vowel = 0;

        for(char c : pw) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            }
            else {
                consonant++;
            }
        }

        return vowel >= 1 && consonant >= 2;
    }
}