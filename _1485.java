package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1485 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            ArrayList<Point> pointList = new ArrayList<>();

            for(int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pointList.add(new Point(x, y));
            }

            double[] distance = new double[6];
            int count = 0;

            for(int j = 0; j < 3; j++) {
                for(int k = j + 1; k < 4; k++) {
                    if(j == 0 && k == 1) {
                        distance[count++] = calculate(pointList.get(j), pointList.get(k));
                    }
                    else {
                        distance[count++] = calculate(pointList.get(j), pointList.get(k));
                    }
                }
            }
            boolean isSquare = true;

            Arrays.sort(distance);

            for(int j = 1; j < 4; j++) {
                if(distance[0] != distance[j]) {
                    isSquare = false;
                }
            }

            if(distance[4] != distance[5]) {
                isSquare = false;
            }
            System.out.println(isSquare ? 1 : 0);
        }
    }
    private static double calculate(Point pos1, Point pos2) {
        int dx = pos1.x - pos2.x;
        int dy = pos1.y - pos2.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}