package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long result = 0;
        while(pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();

            result += num1 + num2;

            pq.add(num1 + num2);
        }
        System.out.println(result);
    }
}