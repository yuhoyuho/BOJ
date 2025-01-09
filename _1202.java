package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewel = new Jewel[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewel[i] = new Jewel(weight, value);
        }

        Arrays.sort(jewel, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if(o1.weight == o2.weight) {
                    return o2.value - o1.value; // 무게가 같은 경우, 가격에 대해 내림차순 정렬
                }

                return o1.weight - o2.weight; // 무게에 대해 오름차순 정렬
            }
        });

        int[] bag = new int[K];

        for(int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 가격에 대해서 내림차순 정렬
        long result = 0;

        int j = 0;
        for(int i = 0; i < K; i++) {
            while(j < N && jewel[j].weight <= bag[i]) {
                pq.offer(jewel[j].value);
                j++;
            }
            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }

    static class Jewel {
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}