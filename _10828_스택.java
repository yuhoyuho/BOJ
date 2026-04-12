package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10828_스택 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        Stack st = new Stack();
        while(n-- > 0) {
            String[] arr = br.readLine().split(" ");

            switch(arr[0]) {
                case "push" :
                    st.push(arr[1]);
                    break;
                case "pop" :
                    if(!st.isEmpty()) {
                        sb.append(st.pop()).append('\n');
                        break;
                    }
                    sb.append(-1).append('\n');
                    break;
                case "size" :
                    sb.append(st.size()).append('\n');
                    break;
                case "empty" :
                    if(st.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "top" :
                    if(!st.isEmpty()) {
                        sb.append(st.peek()).append('\n');
                        break;
                    }
                    sb.append(-1).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
