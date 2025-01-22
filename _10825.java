package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Student[] student = new Student[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            student[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(student);

        for(int i = 0; i < n; i++) {
            sb.append(student[i].name + "\n");
        }
        System.out.println(sb);
    }

    static class Student implements Comparable<Student> {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public int compareTo(Student s) {
            if(kor == s.kor) {
                if(eng == s.eng) {
                    if(math == s.math) {
                        return name.compareTo(s.name);
                    }

                    return s.math - math;
                }

                return eng - s.eng;
            }
            return s.kor - kor;
        }
    }
}