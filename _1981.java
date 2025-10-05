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

        bfs(list);
        System.out.println(result);
    }

    static void bfs(ArrayList<Integer> list) {
        result = Integer.MAX_VALUE;
        int left = 0, right = 0;

        while(left < list.size() && right < list.size()) {
            if(isValid(list.get(left), list.get(right))) {
                // 가능한 경로라면 left++, 불가능한 경로라면 right--
                result = Math.min(result, list.get(right) - list.get(left));
                left++;
            }
            else {
                right++;
            }
        }
    }

    static boolean isValid(int left, int right) {
        if (map[0][0] < left || map[0][0] > right) return false;
        if (map[n-1][n-1] < left || map[n-1][n-1] > right) return false;

        boolean[][] visited = new boolean[n][n];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == n-1 && cur.y == n-1) return true;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;

                int val = map[nx][ny];
                if (val < left || val > right) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
        return false;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
