package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1194_달이_차오른다_가자 {
    static int n, m;
    static char[][] map;
    static boolean[][][] visited;
    static int sx, sy;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][1 << 6];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    sx = i;
                    sy = j;
                    map[i][j] = '.'; // 시작 위치도 빈 공간으로 처리
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy, 0, 0));
        visited[sx][sy][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (map[cur.x][cur.y] == '1') {
                return cur.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nextKeys = cur.key;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == '#') {
                    continue;
                }

                char nextPos = map[nx][ny];

                if (nextPos >= 'A' && nextPos <= 'F') {
                    int door = 1 << (nextPos - 'A'); // 해당 문에 필요한 열쇠 비트
                    // 열쇠가 없으면 통과 불가
                    if ((nextKeys & door) == 0) {
                        continue;
                    }
                }
                else if (nextPos >= 'a' && nextPos <= 'f') {
                    int key = 1 << (nextPos - 'a'); // 새로 얻은 열쇠 비트
                    nextKeys |= key; // 기존 열쇠 상태에 추가 (or 연산)
                }

                // 해당 열쇠 상태로 이미 방문한 곳이면 무시
                if (visited[nx][ny][nextKeys]) {
                    continue;
                }

                visited[nx][ny][nextKeys] = true;
                q.add(new Node(nx, ny, nextKeys, cur.cost + 1));
            }
        }

        return -1;
    }

    static class Node {
        int x, y, cost, key;

        public Node(int x, int y, int key, int cost) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.cost = cost;
        }
    }
}
