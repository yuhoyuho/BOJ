package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9205 {
    static StringBuilder sb = new StringBuilder();

    static Position[] store;
    static boolean[] visited;

    static int goalX, goalY, startX, startY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int storeCnt = Integer.parseInt(br.readLine());
            store = new Position[storeCnt];
            visited = new boolean[storeCnt];

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            for(int i = 0; i < storeCnt; i++) {
                st = new StringTokenizer(br.readLine());

                int sx = Integer.parseInt(st.nextToken());
                int sy = Integer.parseInt(st.nextToken());

                store[i] = new Position(sx, sy);
            }

            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            if(Math.abs(goalX - startX) + Math.abs(goalY - startY) <= 1000) {
                sb.append("happy").append('\n');
            }
            else {
                go();
            }
        }
        System.out.println(sb);
    }

    static void go() {
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(startX, startY));

        while(!q.isEmpty()) {
            Position cur = q.poll();

            if(Math.abs(goalX - cur.x) + Math.abs(goalY - cur.y) <= 1000) {
                sb.append("happy").append('\n');
                return;
            }

            for(int i = 0; i < store.length; i++) {
                int sx = store[i].x;
                int sy = store[i].y;

                if(Math.abs(sx - cur.x) + Math.abs(sy - cur.y) <= 1000 && !visited[i]) {
                    visited[i] = true;
                    q.offer(new Position(sx, sy));
                }
            }
        }

        sb.append("sad").append('\n');
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
