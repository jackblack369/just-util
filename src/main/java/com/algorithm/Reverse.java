package com.algorithm;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(val));
        ListNode next = this.next;
        while (next != null) {
            sb.append(next.val);
            next = next.next;
        }
        return sb.toString();
    }
}

public class Reverse {
    //迭代法
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
//            System.out.print("curr.next:" + curr.next.val);
//            System.out.print(", pre:" + prev.val);
//            System.out.println(", curr" + curr.val);
            System.out.println(prev);
        }
        return prev;
    }

    //递归法
    /**
     * 递归法
     */
    public static ListNode reverseList2(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }

        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
        return reverseList2(pre, cur);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

//        ListNode reversed = reverseList(head);
//        System.out.println(reversed);
//        while (reversed != null) {
//            System.out.print(reversed.val + " ");
//            reversed = reversed.next;
//        }

        ListNode reversed2 = reverseList2(null, head);
        System.out.println(reversed2);
    }
}

