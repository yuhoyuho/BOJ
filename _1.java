package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();
            long result = 0;
            Stack<Integer> stack = new Stack<>();

            for(int j = 0; j < N; j++) {
                stack.push(sc.nextInt());
            }

            int x = stack.pop();
            int tmp = x;

            while(!stack.isEmpty()) {
                int y = stack.pop();

                if(tmp > y) {
                    result += (tmp - y);
                }
                else {
                    tmp = y;
                }
            }

            sb.append('#').append(i + 1).append(' ').append(result);
            System.out.println(sb);
        }
    }
}