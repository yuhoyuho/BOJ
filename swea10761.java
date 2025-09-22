package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea10761 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int num = 1;
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int posO = 1, posB = 1;
            int timeO = 0, timeB = 0;
            int result = 0;

            for(int i = 0; i < n; i++) {
                String robot = st.nextToken();
                int target = Integer.parseInt(st.nextToken());

                if(robot.equals("O")) {
                    int move = Math.abs(target - posO);
                    posO = target;
                    timeO = Math.max(timeO + move, result) + 1;
                    result = timeO;
                }
                else {
                    int move = Math.abs(target - posB);
                    posB = target;
                    timeB = Math.max(timeB + move, result) + 1;
                    result = timeB;
                }
            }

            System.out.println("#" + num++ + " " + result);
        }
    }
}
