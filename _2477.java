package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        int[][] arr = new int[6][2];
        int width = 0;
        int height = 0;
        int widthMax = 0;
        int heightMax = 0;

        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 6; i++) {
            if(arr[i][0] == 1 || arr[i][0] == 2) {
                if(widthMax < arr[i][1]) {
                    widthMax = arr[i][1];
                    width = i;
                }
            }
            else if(arr[i][0] == 3 || arr[i][0] == 4) {
                if(heightMax < arr[i][1]) {
                    heightMax = arr[i][1];
                    height = i;
                }
            }
        }

        int w = 0, h = 0;

        if(width == 0) {
            h = Math.abs(arr[5][1] - arr[1][1]);
        }
        else if(width == 5) {
            h = Math.abs(arr[4][1] - arr[0][1]);
        }
        else {
            h = Math.abs(arr[width + 1][1] - arr[width - 1][1]);
        }

        if(height == 0) {
            w = Math.abs(arr[5][1] - arr[1][1]);
        }
        else if(height == 5) {
            w = Math.abs(arr[4][1] - arr[0][1]);
        }
        else {
            w = Math.abs(arr[height + 1][1] - arr[height - 1][1]);
        }

        System.out.println((widthMax * heightMax - w * h) * k);
    }
}
