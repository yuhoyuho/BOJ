package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2263_트리의순회 {
    static int n, idx;
    static int[] pre, in, post;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        preorder(0, n - 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for(int i : pre) {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void preorder(int is, int ie, int ps, int pe) {
        if(is > ie || ps > pe) return;

        pre[idx++] = post[pe];

        int point = is;
        for(int i = is; i <= ie; i++) {
            if(in[i] == post[pe]) {
                point = i;
                break;
            }
        }

        preorder(is, point - 1, ps, ps + point - is - 1);
        preorder(point + 1, ie, ps + point - is, pe - 1);
    }
}
