
/*
 * Created by wxn
 * 2019/4/1 20:33
 */

import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

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


	public static void main(String args[]) {
		int[] arr = {1, 2, 3, 4, 5};
		ListNode listNode = LinkedList.create(arr);
		LinkedList.print(listNode);
		new Solution206().reverseList2(listNode);
		LinkedList.print(listNode);
	}

}
