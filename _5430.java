package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String func = br.readLine();
            int L = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            for(int j = 0; j < L; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            AC(func, dq);
        }

        System.out.println(sb);
    }

    static void AC(String s, ArrayDeque<Integer> deque) {
        boolean isRight = true;

        for(char c : s.toCharArray()) {
            if(c == 'R') {
                isRight = !isRight;
                continue;
            }

            // D && isRight
            if(isRight) {
                if(deque.pollFirst() == null) {
                    sb.append("error").append('\n');
                    return;
                }
            }
            // D && !isRight
            else {
                if(deque.pollLast() == null) {
                    sb.append("error").append('\n');
                    return;
                }
            }
        }
        makeString(deque, isRight);
    }

    static void makeString(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append('[');

        if(deque.size() > 0) {

            if(isRight) {
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }
}