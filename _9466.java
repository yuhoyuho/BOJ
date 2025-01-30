package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9466 {
    static int[] map;
    static boolean[] visited;
    static boolean[] team;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            cnt = 0;

            map = new int[n + 1];
            visited = new boolean[n + 1];
            team = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= n; i++) {
                if(!team[i]) {
                    dfs(i);
                }
            }
            sb.append(n - cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        if(visited[start]) { // 방문한 경우는 사이클이 완성됨
            team[start] = true; // 각 원소들에 대해 팀 편성 처리
            cnt++;
        }
        else { // 아닌 경우는 방문 처리
            visited[start] = true;
        }

        if(!team[map[start]]) { // start가 가리키는 idx의 학생이 팀을 이루지 못한 경우 dfs 호출
            dfs(map[start]);
        }

        visited[start] = false;
        team[start] = true;
    }
}