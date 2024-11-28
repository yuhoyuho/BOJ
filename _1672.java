package BaekJoon;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1672 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] chArr = br.readLine().toCharArray();

        for(int i = N - 1; i >= 1; i--) {
            switch(chArr[i]) {
                case 'A' :
                    switch(chArr[i - 1]) {
                        case 'A' :
                            chArr[i - 1] = 'A'; break;
                        case 'G' :
                            chArr[i - 1] = 'C'; break;
                        case 'C' :
                            chArr[i - 1] = 'A'; break;
                        case 'T' :
                            chArr[i - 1] = 'G'; break;
                    }
                    break;
                case 'G' :
                    switch(chArr[i - 1]) {
                        case 'A' :
                            chArr[i - 1] = 'C'; break;
                        case 'G' :
                            chArr[i - 1] = 'G'; break;
                        case 'C' :
                            chArr[i - 1] = 'T'; break;
                        case 'T' :
                            chArr[i - 1] = 'A'; break;
                    }
                    break;
                case 'C' :
                    switch(chArr[i - 1]) {
                        case 'A' :
                            chArr[i - 1] = 'A'; break;
                        case 'G' :
                            chArr[i - 1] = 'T'; break;
                        case 'C' :
                            chArr[i - 1] = 'C'; break;
                        case 'T' :
                            chArr[i - 1] = 'G'; break;
                    }
                    break;
                case 'T' :
                    switch(chArr[i - 1]) {
                        case 'A' :
                            chArr[i - 1] = 'G'; break;
                        case 'G' :
                            chArr[i - 1] = 'A'; break;
                        case 'C' :
                            chArr[i - 1] = 'G'; break;
                        case 'T' :
                            chArr[i - 1] = 'T'; break;
                    }
                    break;
            }
        }
        System.out.println(chArr[0]);
    }
}