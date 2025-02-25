import model.LPAStudent;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreList(lpaStudents);

        testList(new ArrayList<String>(List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi", "Ivan", "Judy")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    // Wildcard
    public static void printMoreList(List<? extends Student> students) {
        for (var student : students) {
            System.out.println(student.getYearStarted() + " " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for(var element : list){
            if (element instanceof String s)
                System.out.println("String: " + s.toUpperCase());
            else if (element instanceof Integer i)
                System.out.println("Integer: " + i.floatValue());
        }
    }

//    public static <T extends Student> void printList(List<T> students) {
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + " " + student);
//        }
//        System.out.println();
//    }
}
