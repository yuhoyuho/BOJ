package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            if(a > 0) {
                q.add(a);
            }
            else {
                if(!q.isEmpty()) {
                    int result = q.poll();
                    System.out.println(result);
                }
                else {
                    System.out.println(0);
                }
            }
        }
    }
}