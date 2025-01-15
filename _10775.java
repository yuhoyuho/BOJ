package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10775 {
    static int G, P;
    static int[] gate; // 게이트 번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        gate = new int[G + 1];
        for(int i = 0; i <= G; i++) {
            gate[i] = i;
        }

        int cnt = 0;
        for(int i = 1; i <= P; i++) {
            int ap = Integer.parseInt(br.readLine());

            int x = find(ap);

            if(x == 0) {
                break;
            }

            union(x -1, x);
            cnt++;
        }
        System.out.println(cnt);
    }

    static int find(int x) {
        if(x == gate[x]) {
            return x;
        }

        return gate[x] = find(gate[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            gate[y] = x;
        }
    }
}