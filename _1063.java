package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1063 {
    private static char[] king, stone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String dir = br.readLine();
            char[] next_king = move(dir, king);

            if(isInBoard(next_king)) {
                if(next_king[0] == stone[0] && next_king[1] == stone[1]) {
                    char[] next_stone = move(dir, stone);
                    if(isInBoard(next_stone)) {
                        king = next_king;
                        stone = next_stone;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    king = next_king;
                }
            }
            else {
                continue;
            }
        }
        sb.append(king[0]).append(king[1]).append("\n").append(stone[0]).append(stone[1]);
        System.out.println(sb);
    }

    private static boolean isInBoard(char[] pos) {
        if(pos[0] < 'A' || pos[0] > 'H' || pos[1] > '8' || pos[1] < '1') {
            return false;
        }
        else {
            return true;
        }
    }

    private static char[] move(String dir, char[] king) {
        char[] next_king = king.clone();

        switch(dir) {
            case "R" :
                next_king[0]++;
                break;
            case "L" :
                next_king[0]--;
                break;
            case "B" :
                next_king[1]--;
                break;
            case "T" :
                next_king[1]++;
                break;
            case "RT" :
                next_king[0]++;
                next_king[1]++;
                break;
            case "LT" :
                next_king[0]--;
                next_king[1]++;
                break;
            case "RB" :
                next_king[0]++;
                next_king[1]--;
                break;
            case "LB" :
                next_king[0]--;
                next_king[1]--;
                break;
        }
        return next_king;
    }
 }