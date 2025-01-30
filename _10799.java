package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }

            if(s.charAt(i) == ')') {
                stack.pop();

                if(s.charAt(i - 1) == '(') {
                    result += stack.size();
                }
                else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}