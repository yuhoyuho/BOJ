package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11505 {
    static long[] arr, tree;
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for(int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                arr[b] = c;

                update(1, N, 1, b, c);
            }
            if(a == 2) {
                sb.append(multiple(1, N, 1, b, (int)c)).append('\n');
            }
        }
        System.out.println(sb);
    }

    static long init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % mod;
    }

    static long multiple(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 1;
        }
        if(left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return (multiple(start, mid, node * 2, left, right) * multiple(mid + 1, end, node * 2 + 1, left, right)) % mod;
    }

    static long update(int start, int end, int node, int index, long diff) {
        if(index < start || index > end) {
            return tree[node];
        }

        if(start == end) {
            return tree[node] = diff;
        }

        int mid = (start + end) / 2;

        return tree[node] = (update(start, mid, node * 2, index, diff) * update(mid + 1, end, node * 2 + 1, index, diff)) % mod;
    }
}