package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < A; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for(int i = 0; i < A; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }
}