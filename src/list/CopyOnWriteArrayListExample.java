package list;


import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    /*
    CopyOnWriteArrayList - Notes

    What is it?
    A thread-safe variant of ArrayList from java.util.concurrent.

    Core Concept - "Copy on Write"
    Whenever a write operation (add, remove, set) is performed:
    - Instead of modifying the existing list directly, a new copy of the list is created
    - The modification is applied to that copy
    - The internal reference is then updated to point to the new copy
    - All subsequent reads use this new list

    Analogy
    notepad --> notepad-copy --> edits applied to copy --> copy becomes the new notepad

    Read Operations  : Fast and direct, happen on a stable snapshot, no interference from writes
    Write Operations : Slower, a full new copy of the list is created for every modification
                       The reference is then updated so subsequent reads use this new list

    Why use it?
    - Other threads reading the list during a Write are completely unaffected
    - Safe to iterate without ConcurrentModificationException

    When to use it?
    Best suited for read-heavy, write-rare scenarios
    */
    public static void main(String[] args) {


        List<String> products = new ArrayList<>();
        products.add("Milk");
        products.add("Egg");
        products.add("Bread");
        System.out.println("Initial Products List " + products);

        try {
            for (String product : products) { // Throws ConcurrentModificationException
                System.out.println(product);
                if (product.equals("Egg")) {
                    products.add("Butter");
                    System.out.println("Added Butter");
                }
            }
            System.out.println("Final Product List " + products);
        } catch (ConcurrentModificationException ex) {
            System.out.println("Exception: " + ex);
            // Output: Exception: java.util.ConcurrentModificationException
        }



        /*
        ConcurrentModificationException - How it works internally

        Every ArrayList has a hidden counter called modCount.
        modCount increments on every structural modification (add, remove)

            products.add("Milk");   modCount = 1
            products.add("Egg");    modCount = 2
            products.add("Bread");  modCount = 3

        When for-each loop starts, Iterator takes a snapshot of modCount
            int expectedModCount = modCount;  saves current value, say 3

        On every next() call, Iterator checks:
            if (modCount != expectedModCount) throw new ConcurrentModificationException;

        What happens in our code:
            Loop starts        expectedModCount = 3, modCount = 3  OK
            Iteration 1: Milk  check: 3 == 3  OK
            Iteration 2: Egg   check: 3 == 3  OK
              products.add("Butter")  modCount becomes 4
            Iteration 3: next()  check: 4 == 3  MISMATCH  ConcurrentModificationException

        This is called a fail-fast mechanism
        Java fails immediately rather than giving unpredictable or wrong results silently

        Fix 1 - Use a separate list for additions:
            List<String> toAdd = new ArrayList<>();
            for (String product : products) {
                if (product.equals("Egg")) toAdd.add("Butter");
            }
            products.addAll(toAdd);

        Fix 2 - Use CopyOnWriteArrayList:
            List<String> products = new CopyOnWriteArrayList<>();
            Iterator reads the original stable snapshot, write creates a new copy
            So modCount mismatch never happens during iteration
        */

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(products);
        System.out.println("Original Product list " + list);

        for (String product : list) {
            System.out.println(product);
            if (product.equals("Egg")) {
                list.add("Butter");
                System.out.println("Butter Added to product list");
            }
        }
        System.out.println("Final Product List " + list);

    }
}
