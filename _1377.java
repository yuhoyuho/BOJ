package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1377 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        Node[] list = new Node[n + 1];
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            list[i] = new Node(num, i);
        }
        Arrays.sort(list, 1, n + 1);

        int result = 0;
        for(int i = 1; i <= n; i++) {
            result = Math.max(result, list[i].idx - i);
        }

        System.out.println(result + 1);
    }

    static class Node implements Comparable<Node> {
        int num, idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        public int compareTo(Node o) {
            return num - o.num;
        }
    }
}