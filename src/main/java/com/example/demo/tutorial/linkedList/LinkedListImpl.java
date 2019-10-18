package com.example.demo.tutorial.linkedList;

import com.example.demo.tutorial.model.ListNode;
import javafx.util.Pair;

public class LinkedListImpl {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int temp = n;
        for (; fast.next != null; temp--) {
            if (temp <= 0) { //control
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = slow.next.next;//delete Nth
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead;
        if (l1.val <= l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    ListNode ref;

    public boolean isPalindrome(ListNode head) {
        ref = head;
        return check(head);
    }

    public boolean check(ListNode node) {
        if (node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val) ? true : false;
        ref = ref.next;
        return ans && isEqual;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // recursion bottom up, calculate whether there is a carry.
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            Pair<Integer, Integer> ans = add(l1.val, l2.val, carry);
            dummy.next = new ListNode(ans.getKey());
            carry = ans.getValue();
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            Pair<Integer, Integer> ans = add(l1.val, 0, carry);
            dummy.next = new ListNode(ans.getKey());
            carry = ans.getValue();
            dummy = dummy.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            Pair<Integer, Integer> ans = add(0, l2.val, carry);
            dummy.next = new ListNode(ans.getKey());
            carry = ans.getValue();
            dummy = dummy.next;
            l2 = l2.next;
        }

        return head.next;
    }

    public Pair<Integer, Integer> add(int n1, int n2, int carry) {
        int val = n1 + n2 + carry;
        return new Pair<Integer, Integer>(val % 10, val / 10);
    }
}
