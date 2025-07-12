package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Jewel(w, v);
        }

        Arrays.sort(jewels);

        int[] bag = new int[k];
        for(int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        long result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        for(int i = 0; i < k; i++) {
            while(idx < n && jewels[idx].w <= bag[i]) {
                pq.offer(jewels[idx].v);
                idx++;
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }

    static class Jewel implements Comparable<Jewel> { // 보석의 무게, 가격 저장
        int w, v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }

        public int compareTo(Jewel o) {
            if(w == o.w) {
                return o.v - v;
            }

            return w - o.w;
        }
    }
}
