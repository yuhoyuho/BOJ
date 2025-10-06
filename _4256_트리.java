package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _4256_트리 {
    static int n, idx;
    static int[] pre, in, post;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            idx = 0;
            pre = new int[n];
            in = new int[n];
            post = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                pre[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {

                in[i] = Integer.parseInt(st.nextToken());
            }

            postorder(0, n - 1, 0, n - 1);

            Arrays.stream(post)
                    .forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    static void postorder(int ps, int pe, int is, int ie) {
        if(ps > pe || is > ie) {
            return;
        }

        int root = pre[ps];
        int point = is;

        for(int i = is; i <= ie; i++) {
            if(in[i] == pre[ps]) {
                point = i;
                break;
            }
        }

        int leftSize = point - is;

        postorder(ps + 1, ps + leftSize, is, point - 1);
        postorder(ps + leftSize + 1, pe, point + 1, ie);

        post[idx++] = root;
    }
}
