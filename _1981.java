package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1981 {
    static int n, result;

    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                set.add(map[i][j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        /// TODO : left, right 조정해가면서(투포인터) 해당 값을 지나치고 나머지 값이 그 범위 안에 있는지 확인하는 bfs 돌리기

        bfs();
        System.out.println(result);
    }

    static void bfs() {
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
