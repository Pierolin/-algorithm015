package algorithm015.test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Stack
        System.out.println("*********** Stack ***********");
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println("3的位置" + stack.search(3));

        // Queue
        System.out.println("*********** Queue ***********");
        Queue<String> queue = new LinkedList<String>();

        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("one");

        System.out.println(queue);

        String pollElement = queue.poll();
        System.out.println(pollElement);
        System.out.println(queue);

        String peekElement = queue.peek();
        System.out.println(peekElement);
        System.out.println(queue);

        while(queue.size()>0){
            System.out.println(queue.poll());
        }

        System.out.println("*********** Dequeue ***********");
        Deque<String> deque = new LinkedList<String>();
        deque.add("AAAA");
        deque.add("BBBB");
        deque.add("CCCC");
        deque.add("DDDD");
        deque.push("EEEE");
        deque.add("FFFF");
        System.out.println(deque);

        String peekDequeElement = deque.peek();
        System.out.println(peekDequeElement);
        System.out.println(deque);

        while(deque.size()>0){
            System.out.println(deque.pop());
        }
        System.out.println(deque);

        System.out.println("*********** PriorityQueue ***********");
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
    }
}
