package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17822 {
    static int n, m, t, result;
    static ArrayList<ArrayList<Integer>> list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            flag = false; // 아래 반복문이 끝난 시점에서 true면 인접한 수를 지운 것을 의미
            spinning(x, d, k); // 원판 돌리기

            for(int i = 1; i <= n; i++) {
                for(int j = 0; j < m; j++) {
                    if(list.get(i).get(j) != -1) {
                        check(i, j, list.get(i).get(j)); // 인접한 수 찾기 + 지우기
                    }
                }
            }

            if(!flag) {
                calculate();
            }
        }
        result = 0;
        sum();

        System.out.println(result);
    }

    static void spinning(int x, int d, int k) { // x의 배수인 원판을 d 방향으로 k칸 회전 / d = 0 시계, d = 1 반시계
        for(int i = 1; i <= n; i++) {
            if(i % x == 0) {
                ArrayList<Integer> circle = list.get(i);

                if(d == 0) { // 시계 방향
                    for(int j = 0; j < k; j++) {
                        circle.add(0, circle.remove(circle.size() - 1));
                    }
                }
                else { // 반시계 방향
                    for(int j = 0; j < k; j++) {
                        int num = circle.remove(0);
                        circle.add(circle.size(), num);
                    }
                }
            }
        }
    }

    static void check(int x, int y, int num) { // 인접한 칸에 같은 수가 있는지 확인, 있으면 -1로 바꿈.
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny == m) {
                ny = 0;
            }
            if(ny == -1) {
                ny = m - 1;
            }

            if(isInRange(nx) && list.get(nx).get(ny) == num && list.get(nx).get(ny) != -1) {
                list.get(nx).set(ny, -1);
                flag = true;
                check(nx, ny, num);
            }
        }
    }

    static void calculate() {
        int sum = 0;
        int cnt = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                if(list.get(i).get(j) != -1) {
                    sum += list.get(i).get(j);
                    cnt++;
                }
            }
        }

        if(cnt == 0) {
            return;
        }

        double avg = (double) sum / cnt;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                if(list.get(i).get(j) != -1) {
                    if(list.get(i).get(j) > avg) { // 평균보다 크면 그 값에서 -1
                        list.get(i).set(j, list.get(i).get(j) - 1);
                    }
                    else { // list.get(i).get(j) == avg 인 경우 else 를 사용하지 않으면 의도치 않게 +1이 될 수도 있음.
                        if(list.get(i).get(j) < avg) { // 작으면 +1
                            list.get(i).set(j, list.get(i).get(j) + 1);
                        }
                    }
                }
            }
        }
    }

    static void sum() {
        result = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                if(list.get(i).get(j) != -1) {
                    result += list.get(i).get(j);
                }
            }
        }
    }

    static boolean isInRange(int x) {
        return x >= 1 && x <= n;
    }
}