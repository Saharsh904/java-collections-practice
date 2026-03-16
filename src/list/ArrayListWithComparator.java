package list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StringLenghtComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

class Student {
    String name;
    Double gpa;

    public Student(String name, Double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public Double getGpa() {
        return gpa;
    }
}

public class ArrayListWithComparator {
    public static void main(String[] args) {

        /*
         ============================================================
                  Comparator — compare(a, b) Full Concept
         ============================================================

         Comparator is a functional interface in Java used to define custom sorting
         logic for objects. It allows you to sort in any order — ascending,
         descending, or based on any field/condition — independent of the object's
         natural ordering.

         CORE IDEA:
         ----------
         We don't care about the actual difference value.
         We only care about its sign:

               any negative  →  treated as  -1
               zero          →  treated as   0
               any positive  →  treated as  +1

          Visualise it as a number line:

                  a         b
             ─────●─────────●─────
                 -1    0   +1

            -1 (negative)  →  a comes first  →  no swap
             0 (zero)      →  equal          →  no swap
            +1 (positive)  →  b comes first  →  swap

          ============================================================

          ASCENDING ORDER  →  (a, b) -> a - b
          ------------------------------------------------------------
          If a is smaller → result is negative → a stays first
          → smaller elements come first → Ascending

            Example 1: compare(5, 9)
               a - b = 5 - 9 = -4  →  negative (-1)
               5 is smaller → a comes first
               Order: [5, 9]

            Example 2: compare(5, 2)
               a - b = 5 - 2 = +3  →  positive (+1)
               5 is bigger → b comes first
               Order: [2, 5]

          ============================================================

          DESCENDING ORDER  →  (a, b) -> b - a
          ------------------------------------------------------------
          If b is smaller → result is negative → a stays first
          → larger elements come first → Descending

            Example 1: compare(5, 9)
               b - a = 9 - 5 = +4  →  positive (+1)
               9 is bigger → b comes first
               Order: [9, 5]

            Example 2: compare(5, 2)
               b - a = 2 - 5 = -3  →  negative (-1)
               5 is bigger → a comes first
               Order: [5, 2]

          ============================================================
         */

        List<Integer> list1 = new ArrayList<>(List.of(2, 5, 3, 6, 4, 1));

        /*
        When null is passed to list.sort(), it sorts using the natural ordering of
        the elements (e.g., ascending for integers, alphabetical for strings)
        — same as calling Collections.sort(list).
         */
        list1.sort(null);

        System.out.println(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("Date");
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Cherry");

        list2.sort(null); // [Apple, Banana, Cherry, Dates] -> Alphabetically sorted
        System.out.println(list2);

        List<String> list3 = new ArrayList<>(List.of("Hello", "Hi", "Greetings", "Hey"));

        //Comparator using Custom class
        list3.sort(new StringLenghtComparator());
        System.out.println(list3);


        //Comparator using lambda expression
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harry", 6.7));
        students.add(new Student("Vik", 9.6));
        students.add(new Student("JJ", 4.4));
        students.add(new Student("Tobi", 9.0));
        students.add(new Student("Simon", 7.8));
        students.add(new Student("Josh", 8.5));
        students.add(new Student("Ethan", 4.4));

        students.sort((a, b) -> {
            if (b.getGpa() - a.getGpa() > 0) {
                return 1;
            } else if (b.getGpa() - a.getGpa() < 0) {
                return -1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getGpa());
        }
    }
}
