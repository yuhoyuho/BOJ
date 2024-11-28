package BaekJoon;
import java.util.Scanner;

public class _1173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        int min = m;
        int count = 0;

        if (M - m < T) {
            System.out.println(-1);
        } else {
            while(true) {
                if(m + T <= M) {
                    N--;
                    m += T;
                } else {
                    m -= R;
                }

                if(m < min) {
                    m = min;
                }

                count++;

                if(N == 0) {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}