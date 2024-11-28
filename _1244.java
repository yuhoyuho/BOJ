package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int button = Integer.parseInt(br.readLine());
        int[] pos = new int[button];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < button; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        for(int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1) {
                for(int j = 0; j < button; j++) {
                    if((j + 1) % num == 0) {
                        pos[j] = pos[j] == 0 ? 1 : 0;
                    }
                }
            }
            else {
                pos[num - 1] = pos[num - 1] == 0 ? 1 : 0;

                for(int j = 0; j < button / 2; j++) {
                    if(num - 1 - j < 0 || num - 1 + j >= button) {
                        break;
                    }

                    if(pos[num - 1 - j] == pos[num - 1 + j]) {
                        pos[num - 1 - j] = pos[num - 1 - j] == 0 ? 1 : 0;
                        pos[num - 1 + j] = pos[num - 1 + j] == 0 ? 1 : 0;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < button; i++) {
            System.out.print(pos[i] + " ");

            if((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}