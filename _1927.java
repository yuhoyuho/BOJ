package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x > 0) {
                q.add(x);
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