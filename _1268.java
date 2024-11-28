package BaekJoon;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] student = new int[N][5];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int leader = 0;

        for(int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();

            for(int j = 0; j < 5; j++) {

                for(int k = 0; k < N; k++) {
                    if(student[i][j] == student[k][j] && i != k) {
                        set.add(k);
                    }
                }
            }

            if(set.size() > max) {
                leader = i;
                max = set.size();
            }
        }

        System.out.println(leader + 1);
    }
}