package org.blacksun.pediredla;

/**
 * Created by Pediredla on 1/7/17.
 */
public class LinkedListQuestions {
    public ListNode reverseLinkedList(ListNode root) {
        ListNode reverse = null;
        while (root != null) {
            ListNode temp = root.next;
            root.next = reverse;
            reverse = root;
            root = temp;
        }
        return reverse;
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode swap = head.next;
        head.next = swapPairs(head.next.next);
        swap.next = head;
        return swap;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            this.val = v;
        }
    }
}