package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1039 {
    static int n, m ,k , result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        result = -1;
        bfs(n, 0);
        System.out.println(result);
    }

    static void bfs(int num, int cnt) {
        Queue<Number> q = new LinkedList<>();
        q.offer(new Number(num, 0));

        // 전체 경우의 수에서 k번 바꿨을 때 나온 수 방문 처리, k >= 1이기 때문에 k + 1
        boolean[][] visited = new boolean [1000001][k + 1];
        visited[num][0] = true;

        while(!q.isEmpty()) {
            Number x = q.poll();

            if(x.cnt == k) { // k번 교환한 경우, 최대값을 갱신하고 다음 큐로 넘어감
                result = Math.max(result, x.num);
                continue;
            }

            m = String.valueOf(x.num).length();

            for(int i = 0; i < m - 1; i++) {
                for(int j = i + 1; j < m; j++) {
                    int next = swap(x.num, i, j);

                    if(next != -1 && !visited[next][x.cnt + 1]) {
                        visited[next][x.cnt + 1] = true;
                        q.offer(new Number(next, x.cnt + 1));
                    }
                }
            }
        }
    }

    static int swap(int num, int i, int j) {
        char[] chArr = String.valueOf(num).toCharArray();

        if(i == 0 && chArr[j] == '0') {
            return -1;
        }

        char c = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = c;

        return Integer.parseInt(new String(chArr));
    }

    static class Number {
        int num, cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}