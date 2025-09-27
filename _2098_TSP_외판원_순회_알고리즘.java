package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2098_TSP_외판원_순회_알고리즘 {
    static int n, bitStatus, INF = 987654321;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {
        /**
         * // TSP : Traveling Salesman Problem -> 조합 최적화 문제 //
         * 선수 지식으로 비트 마스크를 알면 좋음 (몰라서 재귀로 풀 수 있다는데 난 잘 이해가 안된다.. 시간 초과 날 것 같기도)
         *
         * 1) Brute Force로 해결
         * - 가장 쉬운 방법. 그러나 n이 20이면 시간 복잡도는 o(n!)이므로 사실상 n이 굉장히 작은 크기가 아니라면 불가능
         *
         * 2) Dynamic Programming으로 해결
         * - 판매원이 i번 도시에 있다고 가정.
         * - 방문하지 않은 도시들 중 다음 도시를 정해야함
         * - 여기서 남은 도시들 중 하나를 방문했다고 '가정'한 뒤 그 도시를 뺀 나머지 도시를 최적의 경로로 방문하는 방법을 사용
         * ex) 1,2,3,4,5번 도시 중 이미 1,2번은 방문했고 3,4,5를 방문해야 하는 상황
         *      - 3번을 방문했다고 가정 : 4,5번 도시를 최적의 경로로 방문
         *      - 4번을 방문했다고 가정 : 3,5번 도시를 최적의 경로로 방문
         *      - 5번을 방문했다고 가정 : 3,4번 도시를 최적의 경로로 방문
         * -> 이 중 최솟값을 가지는 경우가 답에서 묻는 도시가 된다.
         *
         * 정리 : 아직 방문하지 않은 노드 중 하나를 방문했다고 '가정'한 후, 그 노드를 제외한 나머지 노드들을 마저 돌았을 때의 거리를 구함.
         * (이 거리) + (현재 노드와 방문했다고 가정한 노드의 거리) = 최소 거리
         * 즉, 다음 이동해야할(방문했다고 가정한) 노드를 제외하고 나머지 노드를 순회했을 때의 거리를 구함. 이 거리 + 다음 노드까지의 비용이 최솟값이다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        bitStatus = (1<<n) - 1; // 왼쪽으로 n칸 밀기
        cost = new int[n][n];
        dp = new int[n][bitStatus];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1)); // 0번 도시부터 탐색 시작 (check : 0001)
    }

    static int tsp(int x, int check) {
        // 모든 도시 방문한 경우 (check가 bitStatus로 나타낼 수 있는 모든 수 탐색, 여기서는 1111(15) )
        if(check == bitStatus) {
            if(cost[x][0] == 0) {
                return INF;
            }
            return cost[x][0];
        }

        // 현재 위치가 이미 방문한 경우
        if(dp[x][check] != -1) {
            return dp[x][check];
        }

        // 방문 표시 (dp를 위해 큰 값으로 초기화)
        dp[x][check] = INF;

        for(int i = 0; i < n; i++) {
            // 방문
            int next = check | (1<<i);

            if(cost[x][i] == 0 || (check & (1<<i)) != 0) {
                continue;
            }

            dp[x][check] = Math.min(dp[x][check], tsp(i, next) + cost[x][i]);
        }

        return dp[x][check];
    }
}

