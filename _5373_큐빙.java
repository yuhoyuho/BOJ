package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5373_큐빙 {
    static char[][][] map;
    static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'};
    static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            // TODO : 큐브 돌리기
            // U : White, D : Yellow, F : Red, B : Orange, L : Green, R : Blue
            // + : 시계 방향, - : 반시계 방향
            init();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; ++i) {
                String s = st.nextToken();
                char face = s.charAt(0);
                char dir = s.charAt(1);

                cubing(face, dir);
            }

            write();
        }
        System.out.println(sb);
    }

    static void write() {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0 ; j < 3; ++j) {
                sb.append(map[U][j][2 - i]);
            }
            sb.append('\n');
        }
    }

    static void init() {
        map = new char[6][3][3];

        for(int k = 0; k < 6; k++) {
            for(int i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    map[k][i][j] = color[k];
                }
            }
        }
    }

    static void turn(int f, int u, int l, int d, int r, char dir) { // f가 바라보는 면
        char[][] face = new char[3][3];
        char[] sub = new char[3];

        if(dir == '+') {
            for(int i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    face[i][j] = map[f][2 - j][i];
                }
            }

            for(int i = 0; i < 3; ++i) {
                sub[i] = map[u][i][0];
            }
            for(int i = 0; i < 3; ++i) {
                map[u][i][0] = map[l][0][2 - i];
            }
            for(int i = 0; i < 3; ++i) {
                map[l][0][2 - i] = map[d][2][i];
            }
            for(int i = 0; i < 3; ++i) {
                map[d][2][i] = map[r][2 - i][2];
            }
            for(int i = 0; i < 3; ++i) {
                map[r][2 - i][2] = sub[i];
            }
        }
        else {
            for(int i = 0 ; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    face[i][j] = map[f][j][2 - i];
                }
            }
            for(int i = 0; i < 3; ++i) {
                sub[i] = map[u][i][0];
            }
            for(int i = 0; i < 3; ++i) {
                map[u][i][0] = map[r][2 - i][2];
            }
            for(int i = 0; i < 3; ++i) {
                map[r][2 - i][2] = map[d][2][i];
            }
            for(int i = 0; i < 3; ++i) {
                map[d][2][i] = map[l][0][2 - i];
            }
            for(int i = 0; i < 3; ++i) {
                map[l][0][2 - i] = sub[i];
            }
        }

        map[f] = face;
    }

    static void cubing(char face, char dir) {
        switch (face) {
            case 'U' :
                turn(U, L, F, R, B, dir);
                break;
            case 'D' :
                turn(D, B, R, F, L, dir);
                break;
            case 'F' :
                turn(F, U, L, D, R, dir);
                break;
            case 'B' :
                turn(B, R, D, L, U, dir);
                break;
            case 'L' :
                turn(L, F, U, B, D, dir);
                break;
            case 'R' :
                turn(R, D, B, U, F, dir);
                break;
        }
    }
}
