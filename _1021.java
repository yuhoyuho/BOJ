package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            int target = deque.indexOf(arr[i]);
            int half;

            if(deque.size() % 2 == 0) {
                half = deque.size() / 2 - 1;
            }
            else {
                half = deque.size() / 2;
            }

            if(target <= half) {
                for(int j = 0; j < target; j++) {
                    int tmp = deque.pollFirst();
                    deque.offerLast(tmp);
                    count++;
                }
            }
            else {
                for(int k = 0; k < deque.size() - target; k++) {
                    int tmp = deque.pollLast();
                    deque.offerFirst(tmp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}