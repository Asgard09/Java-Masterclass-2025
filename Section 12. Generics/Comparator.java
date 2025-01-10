import java.util.Arrays;
import java.util.Random;

public class Comparator {

    public static void main(String[] args) {
        AnotherStudent tim = new AnotherStudent("Tim");
        AnotherStudent[] students = {new AnotherStudent("Tim"), new AnotherStudent("Alice"), new AnotherStudent("Bob")} ;
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        StudentGPAComparator gpaComparator = new StudentGPAComparator();
        Arrays.sort(students, gpaComparator);
        System.out.println(Arrays.toString(students));
    }
}

class StudentGPAComparator implements java.util.Comparator<AnotherStudent>{

    @Override
    public int compare(AnotherStudent o1, AnotherStudent o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}
class AnotherStudent implements java.lang.Comparable<AnotherStudent> {
    private static int LAST_ID = 1000;

    private static Random random = new Random();

    String name;

    private int id;

    protected double gpa;

    public AnotherStudent(String name){
        this.id = LAST_ID++;
        this.name = name;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(AnotherStudent o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}

