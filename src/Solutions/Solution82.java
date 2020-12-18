package Solutions;

import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/5/28 20:09
 * <p>
 * 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */


public class Solution82 {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.next.val != cur.val) {
				pre = cur;
				cur = cur.next;
			}
			while (cur.next != null && cur.next.val == cur.val) {
				cur = cur.next;
			}
			if (cur!=pre.next){
				pre.next = cur.next;
				cur.next = null;
				cur = pre.next;
			}else {
				cur = cur.next;
			}
		}
		return dummyHead.next;
	}

	public static void main(String args[]) {
		ListNode head = LinkedList.create(new int[]{1,1,1,1,2,2,3});
		LinkedList.print(head);
		ListNode newHead = new Solution82().deleteDuplicates(head);
		LinkedList.print(newHead);
	}

}
