package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1005 {
    static int[] tower; // 건물 건설에 필요한 시간을 저장
    static int[] count; // 진입 차수를 저장
    static int[] cost; // 각 건물을 지을 때, 최대값을 저장
    static int N;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 건물 개수
            int K = Integer.parseInt(st.nextToken()); // 규칙 개수

            tower = new int[N + 1];
            count = new int[N + 1];
            cost = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>(); // 건물 연결

            for(int i = 1; i <= N; i++) {
                tower[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i <= N; i++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                count[e]++;
                list.get(s).add(e);
            }

            int target = Integer.parseInt(br.readLine());
            topologicalSort();

            sb.append(cost[target] + "\n");
        }
        System.out.println(sb);
    }
    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            if(count[i] == 0) {
                cost[i] = tower[i];
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : list.get(now)) {
                cost[next] = Math.max(cost[now] + tower[next], cost[next]);
                count[next]--;

                if(count[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}