package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            Stack<Character> stack = new Stack<>();

            String s = br.readLine();
            boolean flag = true;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                }
                else {
                    if(stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(flag && stack.isEmpty()) {
                sb.append("YES" + "\n");
            }
            else {
                sb.append("NO" + "\n");
            }
        }
        System.out.println(sb);
    }
}