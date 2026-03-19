package list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {

        /*
        LinkedList is part of the Collection framework and implements the List interface.
        Unlike ArrayList (which uses a dynamic array), LinkedList stores elements as nodes
        in a doubly linked list — giving it different performance characteristics and use cases.
        */

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);

        /*
        LinkedList is a linear data structure where each element is an object called a node.
        Each node has two parts:
          - Data: the value stored in the node
          - Pointers: two references — next (points to next node) and previous (points to previous node)


        Performance Considerations — LinkedList vs ArrayList:

          - Insertions & Deletions: LinkedList is faster — no shifting of elements required.
          - Random Access: LinkedList is slower — has to traverse from the beginning to reach an index.
          - Memory Overhead: LinkedList uses more memory — each node stores 2 extra references (next + previous).
        */

        linkedList.get(2); // O(n)
        linkedList.addFirst(0); // O(1)
        linkedList.addLast(4); // O(1)
        System.out.println(linkedList);

        LinkedList<String> linkedList1 = new LinkedList<>(List.of("Hello", "Namaste", "Bonjour", "Bye", "Ciao", "Hola", "Ni Hao"));
        LinkedList<String> linkedList2 = new LinkedList<>(List.of("Bye", "Adios"));

        linkedList1.removeAll(linkedList2);
        System.out.println(linkedList1);
    }
}
