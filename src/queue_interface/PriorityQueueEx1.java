package queue_interface;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(8);

        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue);


    }
}
