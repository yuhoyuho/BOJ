package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Person[] arr = new Person[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            arr[i] = new Person(age, name);
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());
    }

    static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int compareTo(Person o) {
            return age - o.age;
        }

        public String toString() {
            return age + " " + name + "\n";
        }
    }
}