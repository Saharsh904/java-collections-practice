package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {

        /*
        Vector class in Java

        - Part of java.util package
        - Implements the List interface
        - Legacy class: introduced in JDK 1.0, before the Collections Framework existed
        - Later retrofitted into the Collections Framework

        Key characteristic:
        - Synchronized (all methods are thread-safe)
        - This makes it safe to use in multithreaded environments

        Downside:
        - Synchronization adds overhead
        - In single-threaded scenarios, ArrayList is preferred (faster, no unnecessary locking)

        When to use Vector:
        - Multi-threaded environments where thread safety is a concern
        - Otherwise, prefer ArrayList or use Collections.synchronizedList() for more control
        */

                /*
        Key Features of Vector

        1. Dynamic Array
           - Like ArrayList, Vector grows automatically when capacity is exceeded
           - No need to manually manage size

        2. Synchronized
           - All methods in Vector are synchronized -> thread-safe
           - Multiple threads can work on a Vector without risk of data corruption
           - Downside: introduces performance overhead in single-threaded environments

        3. Legacy Class
           - Part of Java's original release (JDK 1.0)
           - Prefer ArrayList in single-threaded environments for better performance

        4. Resizing Mechanism
           - When capacity is exceeded, Vector doubles its size by default
           - If a capacityIncrement is provided in the constructor, it grows by that fixed amount instead
           - contrast: ArrayList grows by ~50% each time (not double)

        5. Random Access
           - Supports index-based access like arrays and ArrayList
           - O(1) time complexity for get(index)
        */

        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        System.out.println(vector);



        /*
        Constructors of Vector

        1. Vector()
           - Creates a vector with default initial capacity of 10
           - Example:
             Vector<String> v = new Vector<>();

        2. Vector(int initialCapacity)
           - Creates a vector with a specified initial capacity
           - Example:
             Vector<String> v = new Vector<>(20);  // starts with capacity 20

        3. Vector(int initialCapacity, int capacityIncrement)
           - Creates a vector with a given initial capacity
           - When capacity is exceeded, it grows by capacityIncrement (not double)
           - Example:
             Vector<String> v = new Vector<>(10, 5);
             // starts at 10, grows to 15, then 20, then 25... (adds 5 each time)

        4. Vector(Collection<? extends E> c)
           - Creates a vector containing all elements of the given collection
           - Useful for converting an existing collection into a thread-safe Vector
           - Example:
             List<String> list = new ArrayList<>();
             list.add("Leo");
             list.add("Java");
             Vector<String> v = new Vector<>(list);  // v now contains ["Leo", "Java"]
        */
        Vector<Integer> vector1 = new Vector<>();
        int capacity = vector1.capacity();
        System.out.println(capacity);

        Vector<Integer> vector2 = new Vector<>(5);
        int capacity2 = vector2.capacity();
        System.out.println(capacity2);

        Vector<Integer> vector3 = new Vector<>(5);
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);
        vector3.add(1);
        System.out.println(vector3.capacity()); //5
        vector3.add(1);
        System.out.println(vector3.capacity()); //10 = 5*2 (Initial Capacity * 2)

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        System.out.println(arrayList);
        Vector<Integer> vector4 = new Vector<>(arrayList);
        System.out.println(vector4);
    }
}
