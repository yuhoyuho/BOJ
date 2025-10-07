package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _3176_도로_네트워크 {
    static int n, k, height, min, max;
    static int[][] maxDist, minDist, parent;
    static int[] level;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i *= 2) {
            height++;
        }

        parent = new int[n + 1][height];
        maxDist = new int[n + 1][height];
        minDist = new int[n + 1][height];
        level = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }


        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, dist));
            list.get(b).add(new Node(a, dist));
        }

        init(1, 1, 0);
        parentInit();

        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getDistance(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static String getDistance(int a, int b) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int ah = level[a];
        int bh = level[b];

        if(ah < bh) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for(int i = height - 1; i >= 0; i--) {
            if(level[a] - level[b] >= (1 << i)) { // Math.pow(2, i) <= level[a] - level[b] 를 비트 연산으로 표현
                min = Math.min(min, minDist[a][i]);
                max = Math.max(max, maxDist[a][i]);
                a = parent[a][i];
            }
        }

        if(a == b) {
            return min + " " + max;
        }

        for(int i = height - 1; i >= 0; i--) {
            if(parent[a][i] != parent[b][i]) {
                min = Math.min(min, Math.min(minDist[a][i], minDist[b][i]));
                max = Math.max(max, Math.max(maxDist[a][i], maxDist[b][i]));
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        min = Math.min(min, Math.min(minDist[a][0], minDist[b][0]));
        max = Math.max(max, Math.max(maxDist[a][0], maxDist[b][0]));

        return min + " " + max;
    }

    static void parentInit() {
        for(int i = 1; i < height; i++) {
            for(int j = 1; j <= n; j++) {
                if(parent[j][i - 1] != 0) {
                    parent[j][i] = parent[parent[j][i - 1]][i - 1];
                    minDist[j][i] = Math.min(minDist[j][i - 1], minDist[parent[j][i - 1]][i - 1]);
                    maxDist[j][i] = Math.max(maxDist[j][i - 1], maxDist[parent[j][i - 1]][i - 1]);
                }
            }
        }
    }

    static void init(int c, int l, int p) {
        parent[c][0] = p;
        level[c] = l;

        for(Node next : list.get(c)) {
            if(next.num == p) {
                continue;
            }
            minDist[next.num][0] = next.dist;
            maxDist[next.num][0] = next.dist;

            init(next.num, l + 1, c);
        }
    }

    static class Node {
        int num, dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
}
