package list;

import java.util.ArrayList;
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


    }
}
