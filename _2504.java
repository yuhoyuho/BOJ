package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int val = 1;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                val *= 2;
            }
            if(s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                val *= 3;
            }
            if(s.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                else if(s.charAt(i - 1) == '(') {
                    result += val;
                }
                val /= 2;
                stack.pop();
            }
            if(s.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                else if(s.charAt(i - 1) == '[') {
                    result += val;
                }
                val /= 3;
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? result : 0);
    }
}