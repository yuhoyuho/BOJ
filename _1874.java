package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int start = 0;

        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if(value > start) {
                for(int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = value;
            }
            else if(stack.peek() != value) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}