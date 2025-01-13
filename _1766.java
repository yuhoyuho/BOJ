package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1766 {
    static ArrayList<ArrayList<Integer>> list;
    static int[] numList;
    static int N, M;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numList = new int[N + 1];
        list = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.get(s).add(e);
            numList[e]++;
        }
        solution(numList);
    }

    static void solution(int[] numList) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            if(numList[i] == 0) {
                pq.offer(i);
            }
        }

        while(!pq.isEmpty()) {
            int i = pq.poll();

            sb.append(i).append(' ');

            for(int next : list.get(i)) {
                numList[next]--;

                if(numList[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}