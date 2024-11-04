import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double scoreSum = 0;
		double creditSum = 0;

		for (int i = 0; i < 20; i++) {
			String[] str = br.readLine().split(" ");
			double credit = Double.parseDouble(str[1]);
			String grade = str[2];

			if (!grade.equals("P"))
				creditSum += credit;

			switch (grade) {
			case "A+":
				scoreSum += 4.5 * credit;
				break;
			case "A0":
				scoreSum += 4.0 * credit;
				break;
			case "B+":
				scoreSum += 3.5 * credit;
				break;
			case "B0":
				scoreSum += 3.0 * credit;
				break;
			case "C+":
				scoreSum += 2.5 * credit;
				break;
			case "C0":
				scoreSum += 2.0 * credit;
				break;
			case "D+":
				scoreSum += 1.5 * credit;
				break;
			case "D0":
				scoreSum += 1.0 * credit;
				break;
			case "F":
				scoreSum += 0.0 * credit;
				break;
			}
		}

		double gpa = scoreSum / creditSum;

		System.out.printf("%.6f%n", gpa);

	}

}