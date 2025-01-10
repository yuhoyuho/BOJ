package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16946 {
    static int N, M;
    static char[][] map;
    static int[][] group;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        group = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int idx = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '0' && group[i][j] == 0) {
                    hm.put(idx, bfs(i, j, idx));
                    idx++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(count(i, j));
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
    static int count(int x, int y) {
        int sum = 1;
        HashSet<Integer> hs = new HashSet<>();

        if(map[x][y] == '0') {
            return 0;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if(group[nx][ny] == 0) {
                continue;
            }

            if(map[nx][ny] == '0') {
                hs.add(group[nx][ny]);
            }
        }

        for(int i : hs) {
            sum += hm.get(i);
        }

        return sum % 10;
    }

    static int bfs(int x, int y, int groupNum) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        group[x][y] = groupNum;
        int cnt = 1;

        while(!q.isEmpty()) {
            Node node = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if(map[nx][ny] == '0' && group[nx][ny] == 0) {
                    group[nx][ny] = groupNum;
                    q.offer(new Node(nx, ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}