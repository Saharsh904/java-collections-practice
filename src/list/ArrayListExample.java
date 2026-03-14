package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();


        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(20);

        /*
        arrayList.add(5)

        Here 5 is a primitive int, but the List stores Integer objects.
        Java automatically converts int to Integer using Autoboxing.

        Internally it becomes:
        arrayList.add(Integer.valueOf(5));
         */

        System.out.println(arrayList.get(2)); // 20

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        /*

        int x = num;

        Here num is an Integer object, but x is a primitive int.
        Java automatically converts Integer to int using Unboxing.

        Internally it becomes:
        int x = num.intValue();

         */
        for (int x : arrayList) {
            System.out.println(x);
        }


        /*
        Q: Why can't Java collections store primitive types?

        Answer:Java collections use Generics, and generics work only with
        objects (reference types), not primitive types. Therefore, wrapper
        classes like Integer, Double, etc. are used.

         */

        System.out.println(arrayList.contains(20)); //True
        System.out.println(arrayList.contains(2)); // False

        arrayList.remove(2);
        arrayList.add(2, 20);

        //Update 2nd index value to 50.
        arrayList.set(2, 50);
        System.out.println(arrayList);

        /*
        ArrayList - Adding Elements (Internal Working)

        1. Check Capacity
            Before adding a new element, ArrayList checks if there is enough
            space in the internal array (elementData).

        2. Resize if Required
            If the internal array is full, a new array is created with a larger
            capacity (usually 1.5x the current capacity), and elements are
            copied from the old array to the new one.

        3. Add Element
            The new element is inserted at the appropriate index and the
            size of the ArrayList is incremented.
        */

        /*
        ArrayList Resizing

        1. Initial Capacity
           Default capacity of ArrayList is 10.

        2. Growth Factor
           When the internal array becomes full, a new array is created
           with 1.5 × the previous capacity.

        3. Copying Elements
           All elements from the old array are copied to the new array.
           This resizing operation takes O(n) time.
        */


        List<Integer> list1 = new ArrayList<>(1000);


        ArrayList<Integer> list2 = new ArrayList<>(11);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(1); // 11 times

        System.out.println(list2.size()); // 11

        /*
        ArrayList Capacity Growth Example

        Initial capacity = 11

        After adding 11 elements, the internal array becomes full.
        When we add one more element, ArrayList needs to resize.

        New capacity = old capacity + (old capacity / 2)
                      = 11 + 5
                      = 16

        Internally Java uses to increase the size of the arraylist:-
        newCapacity = oldCapacity + (oldCapacity >> 1)
        equivalent to => newCapacity = oldCapacity + (oldCapacity / 2)

        So the internal array grows from 11 → 16  (11 + 11/2 => 11 + 5 = 16).
        This resizing helps balance memory usage and resizing cost.
        */


        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(2);
        list2.remove(2); // 8 times

        /*
        Removing elements from an ArrayList does not reduce its capacity.
        The internal array size remains the same even after elements are removed.
        To reduce the capacity to match the current size, we can use trimToSize().
         */

        list2.trimToSize();


        //ArrayList Declaration
        List<Integer> list3 = new ArrayList<>();
        System.out.println(list3.getClass().getName()); //java.util.ArrayList

        //On the fly Creation of ArrayList
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list4.getClass().getName()); //java.util.Arrays$ArrayList

        String[] str = {"Sat", "Sun"};
        List<String> list5 = Arrays.asList(str);
        System.out.println(list5.getClass().getName()); //java.util.Arrays$ArrayList

        List<Integer> list6 = List.of(1, 2, 3, 4, 5, 6, 7);
        System.out.println(list6.getClass().getName()); //java.util.ImmutableCollections$ListN

        /*
        Why Different?
        `list3` → `new ArrayList<>()`

        You're explicitly creating a `java.util.ArrayList` — the standard, full-featured ArrayList from
        the `java.util` package. Nothing surprising here.

        `list4` and `list5` → `Arrays.asList(...)`
        This does not return a `java.util.ArrayList`.
        It returns a #private static inner class defined inside the `Arrays` class, which is why the name shows:

        java.util.Arrays$ArrayList
                    ↑        ↑
                    outer  inner class
                    ($ = nested)

         * ┌─────────────────────┬──────────────────┬─────────────────────┬─────────────────────┐
         * │ Feature             │ new ArrayList<>()│ Arrays.asList()     │ List.of()           │
         * ├─────────────────────┼──────────────────┼─────────────────────┼─────────────────────┤
         * │ Resizable           │ Yes              │ No                  │ No                  │
         * │ add() / remove()    │ Works            │ UnsupportedOpEx     │ UnsupportedOpEx     │
         * │ set() (update)      │ Works            │ Works               │ UnsupportedOpEx     │
         * │ Allows null         │ Yes              │ Yes                 │ No                  │
         * │ Backed by array     │ No               │ Yes (no copy!)      │ No                  │
         * └─────────────────────┴──────────────────┴─────────────────────┴─────────────────────┘

         Arrays.asList() -> partially mutable (set allowed, add/remove not allowed)
         List.of()       -> fully immutable   (set, add/remove all not allowed)


        The Gotcha with Arrays.asList()
        javaString[] str = {"Sat", "Sun"};
        List<String> list5 = Arrays.asList(str);
        str[0] = "Mon";
        System.out.println(list5.get(0)); // prints "Mon" ← list reflects the change!

        Since Arrays.asList() wraps the original array (not a copy), changes to the array are
        reflected in the list and vice versa.
        */

        List<Integer> list7 = new ArrayList<>(list6); //Converting java.util.ImmutableCollections$ListN to java.util.ArrayList
        list7.add(45);
        System.out.println(list7);

        //========Adding Elements===========
        List<Integer> list8 = new ArrayList<>();
        list8.add(1);
        list8.add(2);
        list8.add(3);

        //Index based adding
        list8.add(0, 0);

        //Adding Collection
        List<Integer> list9 = List.of(4, 5, 6, 7, 8, 9);
        list8.addAll(list9);

        System.out.println(list8);

        //======Removing Elements===========
        List<String> list10 = new ArrayList<>();
        list10.add("Apple");
        list10.add("Banana");
        list10.add("Cherry");
        list10.add("Dragon Fruit");

        //Index Based Removal
        list10.remove(3);

        //Object Based Removal - removes the first occurrence of the object passed
        list10.remove("Apple");

        System.out.println(list10);

        //Object Based Removal with Integer type
        List<Integer> list11 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        /*
         For index-based  removal: list.remove(1) -> removes element at index 1
         For object-based removal: list.remove(Integer.valueOf(1)) -> removes element with value 1

         Wrap the value explicitly to avoid accidental index-based removal in Integer lists.
        */

        list11.remove(Integer.valueOf(1));

        System.out.println(list11);

        //Convert ArrayList to Array
        List<Integer> list12 = new ArrayList<>(List.of(1, 2, 3));


        Object[]  array1 = list12.toArray();
        Integer[] array2 = list12.toArray(new Integer[0]);

        /*
         toArray()                  -> returns Object[]  (no type info, needs casting)
         toArray(new Integer[0])    -> returns Integer[] (typed, preferred, no casting needed)

         Passing new Integer[0] is a hint to JVM to return the correct typed array.
        */

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array1));


        //=============Sorting=============
        List<Integer> list13 = new ArrayList<>(List.of(2,5,1,6,9,4,7,12,1));
        Collections.sort(list13);

        /*
         Collection  (without 's') -> Interface  (java.util.Collection)
         Collections (with 's')    -> Utility class (java.util.Collections)

         Collections class provides static utility methods like:
         sort(), reverse(), shuffle(), min(), max(), frequency() etc.
        */

        System.out.println(list13);

        /*
         ArrayList - Time Complexity

         get(index)     -> O(1)  (direct index access)
         add(element)   -> O(1) amortized, O(n) worst case (when resizing occurs)
         remove(index)  -> O(n)  (elements need to shift after removal)
         iteration      -> O(n)
        */
    }
}
