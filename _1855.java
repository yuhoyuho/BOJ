package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1855 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < s.length() / N; j++) {
                sb.append(s.charAt(j % 2 == 0 ? j * N + i : j * N + N - 1 - i));
            }
        }

        System.out.println(sb);
    }
}