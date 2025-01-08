package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch(c) {
                case '+':
                case '-' :
                case '*' :
                case '/' :
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(' :
                    stack.push(c);
                    break;
                case ')' :
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default :
                    sb.append(c);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
    static int priority(char operator) {
        if(operator == '(' || operator == ')') {
            return 0;
        }
        else if(operator == '+' || operator == '-') {
            return 1;
        }
        return 2;
    }
}