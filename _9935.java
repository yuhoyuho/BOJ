package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if(stack.size() >= bomb.length()) {
                boolean isRight = true;

                for(int j = 0; j < bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isRight = false;
                        break;
                    }
                }

                if(isRight) {
                    for(int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }

        for(char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}