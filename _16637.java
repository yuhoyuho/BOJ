package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16637 {
    static int n, result;
    static char[] operator;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        num = new int[n / 2 + 1];
        operator = new char[n / 2];

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                num[i / 2] = s.charAt(i) - '0';
            }
            else {
                operator[i / 2] = s.charAt(i);
            }
        }

        result = Integer.MIN_VALUE;
        dfs(num[0], 0);

        System.out.println(result);
    }

    static int calc(char operator, int x, int y) {
        switch (operator) {
            case '*' :
                return x * y;
            case '+' :
                return x + y;
            case '-' :
                return x - y;
        }

        return 0;
    }

    static void dfs(int tmp, int idx) { // operator 를 만나면 괄호 O/X 로 나눠서 dfs
        if(idx >= n / 2) {
            result = Math.max(tmp, result);
            return;
        }

        // 괄호 사용하지 않는 경우
        int result1 = calc(operator[idx], tmp, num[idx + 1]);
        dfs(result1, idx + 1);

        // 괄호 사용하는 경우
        if(idx < n / 2 - 1) {
            int result2 = calc(operator[idx + 1], num[idx + 1], num[idx + 2]);
            dfs(calc(operator[idx], tmp, result2), idx + 2);
        }
    }
}
