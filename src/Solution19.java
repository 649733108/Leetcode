import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

import java.util.Stack;

/**
 * Created by wxn
 * 2019/6/10 10:49
 *
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution19 {

	//解法1 利用栈
	public ListNode removeNthFromEnd(ListNode head, int n) {
		Stack<ListNode> stack = new Stack<>();
		ListNode cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		for (int i = 0; i < n; i++) {
			cur = stack.pop();
		}
		if (!stack.empty()) {
			ListNode pre = stack.pop();
			pre.next = cur.next;
			cur.next = null;
		}else if (head!=null){
			head = head.next;
			cur.next = null;
		}

		return head;
	}

	//解法2 一趟遍历
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode node1 = head;//node1记录前一个节点
		ListNode node2 = head;//node2记录node1后面第n个节点
		for (int i = 0; i < n; i++) {
			node2 = node2.next;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		while (node2!=null){
			pre = pre.next;
			node1 = node1.next;
			node2 = node2.next;
		}
		pre.next = node1.next;
		node1.next = null;

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedList.create(new int[]{1});
		LinkedList.print(head);
		head = new Solution19().removeNthFromEnd2(head, 1);
		LinkedList.print(head);
	}

}
