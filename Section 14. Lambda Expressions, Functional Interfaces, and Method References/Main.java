import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName+" "+lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("John", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Alice", "Wonderland"),
                new Person("Bob", "Builder")
        ));

        //using anonymous class
        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.lastName().compareTo(p2.lastName());
            }
        };

        people.sort((p1, p2) -> p1.lastName().compareTo(p2.lastName()));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T t1, T t2);
        }

        var comparatorMixed = new EnhancedComparator<Person>(){
            @Override
            public int compare(Person p1, Person p2) {
                int result = p1.lastName().compareTo(p2.lastName());
                return(result == 0 ? secondLevel(p1, p2) : result);
            }

            @Override
            public int secondLevel(Person p1, Person p2) {
                return p1.firstName().compareTo(p2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);
    }
}
