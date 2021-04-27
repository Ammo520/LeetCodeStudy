package day1;

/**
 * @author Liao wenbo
 * @className 两数相加
 * @date 2020/4/12
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return fuc(l1, l2, 0);
    }

    public ListNode fuc(ListNode l1, ListNode l2, int k) {
        ListNode listNode = new ListNode(0);
        if (l1 == null && l2 == null) {
            if (k == 1) {
                listNode = new ListNode(k);
            } else {
                return null;
            }
        } else if (l1 == null) {
            int res = l2.val + k;
            if (res >= 10) {
                res -= 10;
                k = 1;
            } else {
                k = 0;
            }
            listNode.val = res;
            listNode.next = fuc(null, l2.next, k);
        } else if (l2 == null) {
            int res = l1.val + k;
            if (res >= 10) {
                res -= 10;
                k = 1;
            } else {
                k = 0;
            }
            listNode.val = res;
            listNode.next = fuc(l1.next, null, k);
        } else {
            int res = l1.val + l2.val + k;
            if (res >= 10) {
                res -= 10;
                k = 1;
            } else {
                k = 0;
            }
            listNode.val = res;
            listNode.next = fuc(l1.next, l2.next, k);
        }
        return listNode;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
