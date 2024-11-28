package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1459 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long case1, case2, case3;

        case1 = (X + Y) * W;

        if((X + Y) % 2 == 0) {
            case2 = Math.max(X, Y) * S;
        }
        else {
            case2 = (Math.max(X, Y) - 1) * S + W;
        }

        case3 = (Math.min(X, Y) * S) + Math.abs(X - Y) * W;

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }
}