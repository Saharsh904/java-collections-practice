package list;

import java.util.LinkedList;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        /*
        Stack in Java

        1. LIFO Structure
           - Stack follows Last-In-First-Out (LIFO) principle
           - The last element added is the first one to be removed
           - Real-life analogy: a stack of plates — you add and remove from the top

        2. Inheritance
           - Stack is a subclass of Vector
           - So it inherits all Vector features: dynamic array, synchronized, random access
           - But its usage is constrained to LIFO behavior via its own methods (push, pop, peek)

           Hierarchy:
           Object -> Vector -> Stack

        Note:
           - Because Stack extends Vector, it is also synchronized (thread-safe)
           - For modern use, Deque (ArrayDeque) is preferred over Stack
             e.g. Deque<Integer> stack = new ArrayDeque<>();
           - ArrayDeque is faster (not synchronized) and recommended by Java docs
        */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        int pop = stack.pop();
        System.out.println(pop); //5

        Integer peek = stack.peek();
        System.out.println(peek); //4

        System.out.println(stack);

        System.out.println(stack.isEmpty()); //false

        //search() - returns 1-based position from the top (peek = position 1)
        //returns -1 if element not found
        int search = stack.search(3);
        System.out.println(search); // 2 (3 is 2nd from the top)


        /*
        LinkedList can simulate Stack behavior:
        - addLast()    -> equivalent to push()
        - removeLast() -> equivalent to pop()
        - getLast()    -> equivalent to peek()
        */

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        System.out.println(linkedList);

        linkedList.removeLast();

        linkedList.getLast();
    }
}
