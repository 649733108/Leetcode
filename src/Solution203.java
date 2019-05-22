import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/5/22 16:12
 *
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */


public class Solution203 {


	//解法1 暴力法
	public ListNode removeElements(ListNode head, int val) {


		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		ListNode pre = dummyHead;
		ListNode cur = dummyHead.next;

		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
				cur = cur.next;
			}else {
				pre = cur;
				cur = cur.next;
			}
		}
		return dummyHead.next;

	}


	//解法2 递归

	public ListNode removeElements2(ListNode head, int val) {

		if (head == null) {
			return null;
		}
		ListNode node = removeElements2(head.next, val);
		head.next = node;
		if (head.val == val) {
			return node;
		}else {
			return head;
		}

	}
}
