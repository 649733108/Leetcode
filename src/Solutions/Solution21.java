package Solutions;

import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/5/28 20:32
 *
 * 21.合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */


public class Solution21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head;
		if (l1.val<l2.val){
			head = l1;
			head.next = mergeTwoLists(l1.next, l2);
		}else {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
		}
		return head;
	}
}
