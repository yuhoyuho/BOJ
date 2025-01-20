package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1781 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Number[] list = new Number[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[i] = new Number(time, value);
        }

        // list 정렬
        Arrays.sort(list, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if(o2.time == o1.time) {
                    return o2.value - o1.value;
                }

                return o2.time - o1.time;
            }
        });

        PriorityQueue<Number> pq = new PriorityQueue<>();

        int result = 0;
        int cnt = 0;
        for(int i = n; i > 0; i--) {
            while(cnt < n && list[cnt].time == i) {
                pq.offer(list[cnt]);
                cnt++;
            }

            if(pq.isEmpty()) {
                continue;
            }

            result += pq.poll().value;
        }

        System.out.println(result);
    }

    static class Number implements Comparable<Number> {
        int time, value; // 데드라인, 컵라면 수

        public Number(int time, int value) {
            this.time = time;
            this.value = value;
        }

        public int compareTo(Number o) {
            if(value == o.value) {
                return o.time - time;
            }

            return o.value - value;
        }
    }
}