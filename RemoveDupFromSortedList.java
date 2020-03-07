package leetcode.prac;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
//        示例 1:
//
//        输入: 1->1->2
//        输出: 1->2
//        示例 2:
//
//        输入: 1->1->2->3->3
//        输出: 1->2->3

public class RemoveDupFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode cur = head, nextNode = head.next;
        boolean dupNoHandle = false;
        while (cur != null && nextNode != null) {
            if (cur.val == nextNode.val) {
                nextNode = nextNode.next;
                dupNoHandle = true;
            } else {
                cur.next = nextNode;
                cur = nextNode;
                nextNode = nextNode.next;
                dupNoHandle = false;
            }
        }
        if (dupNoHandle) {
            cur.next = nextNode;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
