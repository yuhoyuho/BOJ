package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
            }
            else {
                minHeap.add(num);
            }

            if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if(minHeap.peek() < maxHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(tmp);
                }
            }
            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}