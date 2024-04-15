package mahaboob.com23Roughwork1InternshipCodeWay;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String code;
	private String title;
	private String description;
	private int capacity;
	private String schedule;
	private List<Student> studentsRegistered;

	public Course(String code, String title, String description, int capacity, String schedule) {
		this.code = code;
		this.title = title;
		this.description = description;
		this.capacity = capacity;
		this.schedule = schedule;
		this.studentsRegistered = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getSchedule() {
		return schedule;
	}

	public List<Student> getStudentsRegistered() {
		return studentsRegistered;
	}

	public boolean registerStudent(Student student) {
		if (studentsRegistered.size() < capacity) {
			studentsRegistered.add(student);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeStudent(Student student) {
		return studentsRegistered.remove(student);
	}
}

class Student {
	private String id;
	private String name;
	private List<Course> registeredCourses;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.registeredCourses = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public void registerCourse(Course course) {
		registeredCourses.add(course);
		course.registerStudent(this);
	}

	public boolean dropCourse(Course course) {
		return registeredCourses.remove(course) && course.removeStudent(this);
	}
}

class University {
	private List<Course> courses;
	private List<Student> students;

	public University() {
		this.courses = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Course> getCourses() {
		return courses;
	}

	public List<Student> getStudents() {
		return students;
	}
}
