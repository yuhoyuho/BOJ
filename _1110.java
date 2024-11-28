package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int copy = N;
        int count = 0;

        do {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            count++;
        } while(N != copy);

        System.out.println(count);
    }
}