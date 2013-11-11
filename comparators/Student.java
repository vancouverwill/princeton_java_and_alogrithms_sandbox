package comparators;

import java.util.Arrays;
import java.util.Comparator;

import standard_libraries.StdOut;

public class Student
{
	public static final Comparator<Student> BY_NAME = new ByName();
	public static final Comparator<Student> BY_SECTION = new BySection();
	private final String name;
	private final int section;
	
	// Student constructor
	public Student(String name, int section) {
		/* DO NOT MODIFY */
		this.name = name;
		this.section = section;
	}
	private static class ByName implements Comparator<Student>
	{
		public int compare(Student v, Student w)
		{ return v.name.compareTo(w.name); }
	}
	private static class BySection implements Comparator<Student>
	{
		public int compare(Student v, Student w)
		{ return v.section - w.section; }
	}
	// Test
	public static void main(String[] args) {
//		Student studentOne = new Student("John", 3);
//		Student studentTwo = new Student("Peter", 1);
//		studentOne.ByName(studentTwo);
//		studentOne.BySection(studentTwo);
		
		 Student[] students = new Student[2];
		students[0] = new Student("John", 3);
		students[1] = new Student("Peter", 1);
        Arrays.sort(students, Student.BY_NAME);
        StdOut.println("Sorted by name: ");
        for (int i = 0; i < students.length; i++) {
//            StdOut.println(students[i]);
            StdOut.println(students[i].name);
        }
        StdOut.println();
        Arrays.sort(students, Student.BY_SECTION);
        StdOut.println("Sorted by section: ");
        for (int i = 0; i < students.length; i++) {
//            StdOut.println(students[i]);
            StdOut.println(students[i].section);
        }
	}
}