package algorithm015.Week_02;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l2 == null) l2 = new ListNode(0);
        if (l1 == null) l1 = new ListNode(0);

        ListNode sumListNode = new ListNode(0);
        sumListNode.val = l1.val + l2.val;
        if (sumListNode.val >= 10) {
            sumListNode.val = sumListNode.val - 10;
            if (l1.next != null) {
                l1.next.val++;
            } else {
                l1.next = new ListNode(1);
            }
        }
        sumListNode.next = addTwoNumbers(l1.next, l2.next);
        return sumListNode;
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
