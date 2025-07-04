import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Math", 4);
        grades1.put("Physics", 5);
        grades1.put("Chemistry", 3);
        students.add(new Student("Ivan", "Group A", 1, grades1));

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Math", 2);
        grades2.put("Physics", 3);
        grades2.put("Chemistry", 2);
        students.add(new Student("Maria", "Group B", 2, grades2));

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Math", 5);
        grades3.put("Physics", 5);
        grades3.put("Chemistry", 5);
        students.add(new Student("Alex", "Group A", 1, grades3));

        System.out.println("All students:");
        students.forEach(System.out::println);

        removeUnderperformingStudents(students);
        System.out.println("\nAfter removing underperforming students:");
        students.forEach(System.out::println);

        promoteStudents(students);
        System.out.println("\nAfter promoting students:");
        students.forEach(System.out::println);

        System.out.println("\nStudents on course 2:");
        printStudents(students, 2);
    }

    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }
}