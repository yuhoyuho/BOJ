package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2250 {
    static List<Node> tree = new ArrayList<>(); // 트리의 정보
    static int[] min, max; // 각 level의 최소, 최대값 저장
    static int cnt;
    static int depth; // 트리의 깊이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        min = new int[N + 1];
        max = new int[N + 1];
        int rootIdx = 0; // 루트 노드

        for(int i = 0; i <= N; i++) { // min 배열 초기화 + tree 배열 -1로 초기화.
            min[i] = N;
            max[i] = 0;
            tree.add(new Node(i, -1, -1));
        }

        for(int i = 1; i <= N; i++) { // 트리 초기화
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree.get(num).left = left;
            tree.get(num).right = right;

            if(left != -1) {
                tree.get(left).root = num;
            }

            if(right != -1) {
                tree.get(right).root = num;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(tree.get(i).root == -1) {
                rootIdx = i;
                break;
            }
        }
        dfs(rootIdx, 1);

        int level = 1;
        int result = max[level] - min[level] + 1;

        for(int i = 2; i <= N; i++) {
            int width = max[i] - min[i] + 1;

            if(width > result) {
                level = i;
                result = width;
            }
        }

        System.out.println(level + " " + (max[level] - min[level] + 1));
    }

    static void dfs(int rootIdx, int level) {
        Node root = tree.get(rootIdx);
        if(depth < level) {
            depth = level;
        }

        if(root.left != -1) {
            dfs(root.left, level + 1);
        }

        min[level] = Math.min(min[level], cnt);
        max[level] = cnt;
        cnt++;

        if(root.right != -1) {
            dfs(root.right, level + 1);
        }
    }

    static class Node {
        int root, num, left, right;

        public Node(int num, int left, int right) {
            this.root = -1;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}