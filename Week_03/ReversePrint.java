package algorithm015.Week_03;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        // 方法一：Stack
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;

        // 方法二：copy 链表，遍历链表并计算链接长度
        /*
        int size = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            size++;
            tempNode = tempNode.next;
        }
        int[] result = new int[size];
        int i = 0;
        while (head != null) {
            result[size - (++i)] = head.val;
            head = head.next;
        }
        return result;
        */


        // 方法三 hashmap
        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (head != null) {
            map.put(i++, head.val);
            head = head.next;
        }
        int[] result = new int[i];
        for (int n = 0; n < i; n++) {
            result[n] = map.get(i - n - 1);
        }
        return result;
        */

        //方法四：递归算法
        /*
        ArrayList<Integer> list = new ArrayList<>();
        helper(head, list);
        int size = list.size();
        int[] result = new int[size];
        for (int ele : list) {
            result[--size] = ele;
        }
        return result;
        */
    }

    private void helper(ListNode head, ArrayList<Integer> list) {
        if (head != null) {
            list.add(head.val);
            helper(head.next, list);
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
