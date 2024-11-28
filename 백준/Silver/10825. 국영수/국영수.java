import java.util.*;
import java.io.*;

public class Main {
    public static class Student implements Comparable<Student> {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            if (this.koreanScore != o.koreanScore) {
                return o.koreanScore - this.koreanScore;
            }

            if (this.englishScore != o.englishScore) {
                return this.englishScore - o.englishScore;
            }

            if (this.mathScore != o.mathScore) {
                return o.mathScore - this.mathScore;
            }

            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students);

        for (Student student : students) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}