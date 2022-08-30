package tasks;

import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(7, new ListNode(4, new ListNode(5))))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution sol = new Solution();
        ListNode res = sol.addTwo(l2, l1);
        System.out.println(res.val);
    }

    public ListNode addTwo(ListNode l1, ListNode l2){
        ListNode res = new ListNode();
        int bla = l1.val + l2.val;
        if(bla < 10) {
            res.val = bla;
        } else {
            l1.next.val += 1;
            res.val = bla % 10;
        }
        if (l1.next != null && l2.next != null) {
            res.next = addTwo(l1.next, l2.next);
        } else if(l1.next != null){
            res.next = l1.next;
        } else {
            res.next = l2.next;
        }
        return res;
    }
}