
/*
 * Created by wxn
 * 2019/4/1 20:33
 */

import java.util.Stack;

/**
 * 206.翻转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {


	//解法1 改变参数的结构
	public ListNode reverseList(ListNode head) {

		ListNode pre = null;
		ListNode cur = head;
		while (cur!=null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	//解法2 不改变参数的结构
	public ListNode reverseList2(ListNode head) {

		Stack<Integer>stack = new Stack<>();
		while (head!=null){
			stack.push(head.val);
			head = head.next;
		}
		if (stack.isEmpty())
			return null;
		ListNode node = new ListNode(stack.pop());
		ListNode cur = node;
		while (!stack.isEmpty()){
			cur.next = new ListNode(stack.pop());
			cur = cur.next;
		}
		return node;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {
		ListNode h = new ListNode(1);
		h.next = new ListNode(2);
		h.next.next = new ListNode(3);
		h.next.next.next = new ListNode(4);
		h.next.next.next.next = new ListNode(5);

		new Solution206().reverseList2(h);
	}

}
