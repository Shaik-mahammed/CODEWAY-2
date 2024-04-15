package mahaboob.com23Roughwork1InternshipCodeWay;

import java.util.Scanner;

public class DataBase {
	public static void main(String[] args) {
		University university = new University();

		Course javaCourse = new Course("CS101", "Java Programming", "Introduction to Java programming language", 20,
				"MWF 9:00-10:00");
		Course pythonCourse = new Course("CS102", "Python Programming", "Introduction to Python programming language",
				25, "TTH 13:00-14:30");
		Course javaScriptCourse = new Course("CS103", "Java Script", "Introduction to Java Script", 20,
				"MWW 9:00-10:00");

		university.addCourse(javaCourse);
		university.addCourse(pythonCourse);
		university.addCourse(javaScriptCourse);

		Student student1 = new Student("S001", "Alice");
		Student student2 = new Student("S002", "Bob");

		university.addStudent(student1);
		university.addStudent(student2);

		student1.registerCourse(javaCourse);
		student1.registerCourse(pythonCourse);
		student2.registerCourse(javaCourse);

		System.out.println("Course Listing:");
		for (Course course : university.getCourses()) {
			System.out.println("Course Code: " + course.getCode());
			System.out.println("Title: " + course.getTitle());
			System.out.println("Description: " + course.getDescription());
			System.out.println("Schedule: " + course.getSchedule());
			System.out.println("Available Slots: " + (course.getCapacity() - course.getStudentsRegistered().size()));
			System.out.println();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the course code to drop (or 'exit' to quit): ");
		String courseCode = scanner.nextLine();

		while (!courseCode.equalsIgnoreCase("exit")) {
			Course courseToDrop = null;
			for (Course course : university.getCourses()) {
				if (course.getCode().equalsIgnoreCase(courseCode)) {
					courseToDrop = course;
					break;
				}
			}

			if (courseToDrop != null) {
				boolean dropped = student1.dropCourse(courseToDrop);
				if (dropped) {
					System.out.println("Course dropped successfully.");
				} else {
					System.out.println("Failed to drop course.");
				}
			} else {
				System.out.println("Invalid course code.");
			}

			System.out.print("Enter the course code to drop (or 'exit' to quit): ");
			courseCode = scanner.nextLine();
		}

		scanner.close();
	}
}

