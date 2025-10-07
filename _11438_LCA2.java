package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _11438_LCA2 {
    static int n, m, height;
    static int[][] parent;
    static int[] level;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        /// Sparse Table 알고리즘 사용 : 비트연산을 통해 2^i를 구하고 그 값만큼 점프
        /// DP 알고리즘으로 n = ? 의 이동 지점을 메모이제이션 후 답을 구함
        /// 메모리 사용량은 조금 더 많지만 탐색시간을 O(logN)까지 줄일 수 있음
        /// 기존 LCA 방법은 선형시간 O(N)의 탐색시간을 가짐.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i *= 2) {
            height++;
        }

        parent = new int[n + 1][height]; // 2^i번 점프한 row노드의 값
        level = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        init(1, 1, 0);
        parentInit();

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static void parentInit() {
        for(int i = 1; i < height; i++) {
            for(int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    static void init(int c, int l, int p) {
        level[c] = l;
        parent[c][0] = p; // 이동하지 않았을 때의 c번 값

        for(int next : list.get(c)) {
            if(next == p) {
                continue;
            }

            init(next, l + 1, c);
        }
    }

    static int LCA(int a, int b) {
        int ah = level[a];
        int bh = level[b];

        // ah가 항상 크다고 가정
        if(ah < bh) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        for(int i = height - 1; i >= 0; i--) {
            // level의 차이만큼 이동
            if(Math.pow(2, i) <= level[a] - level[b]) {
                a = parent[a][i];
            }
        }

        if(a == b) {
            return a;
        }

        for(int i = height - 1; i >= 0; i--) {
            if(parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}
