package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        int max = 0;
        long result = 0;
        for(int i = 0; i < n; i++) {
            long x = Long.parseLong(br.readLine());

            map.put(x, map.getOrDefault(x, 0) + 1);

            if(map.get(x) > max) {
                max = map.get(x);
                result = x;
            }

            if(map.get(x) == max) {
                result = Math.min(x, result);
            }
        }
        System.out.println(result);
    }
}