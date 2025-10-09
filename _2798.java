package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class _2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] card = new int [n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int result = IntStream.range(0, n - 2)
                        .flatMap(i -> IntStream.range(i + 1, n - 1)
                                .flatMap(j -> IntStream.range(j + 1, n)
                                        .map(k -> card[i] + card[j] + card[k])
                                )
                        )
                        .filter(sum -> sum <= m)
                        .max()
                        .orElse(0);

        System.out.println(result);
    }
}
