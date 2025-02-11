package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > 0) {
                pos.offer(num);
            }
            else {
                neg.offer(num);
            }
        }

        int result = sum(pos) + sum(neg);

        System.out.println(result);

    }

    static int sum(PriorityQueue<Integer> pq) {
        int result = 0;

        while(!pq.isEmpty()) {
            int cur = pq.poll();

            if(pq.isEmpty()) {
                result += cur;
            }
            else {
                int next = pq.poll();

                if(cur == 1 || next == 1) {
                    result += (cur + next);
                }
                else {
                    result += (cur * next);
                }
            }
        }

        return result;
    }
}