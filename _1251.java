package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class _1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>();

        String s = br.readLine();

        for(int i = 2; i < s.length(); i++) {
            for(int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(s.substring(0, j));
                StringBuilder sb2 = new StringBuilder(s.substring(j, i));
                StringBuilder sb3 = new StringBuilder(s.substring(i));

                String s1 = sb1.reverse().toString();
                String s2 = sb2.reverse().toString();
                String s3 = sb3.reverse().toString();

                list.add(s1 + s2 + s3);
            }
        }

        Collections.sort(list);
        System.out.println(list.pop());
    }
}