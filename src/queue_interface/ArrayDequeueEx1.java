package queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeueEx1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        deque.offerFirst(8);
        deque.offerLast(1);

        System.out.println(deque);
        System.out.println(deque.removeFirst());
        System.out.println(deque);
        System.out.println(deque.removeLast());
        System.out.println(deque);
        System.out.println(deque.pollFirst());
        System.out.println(deque);
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
