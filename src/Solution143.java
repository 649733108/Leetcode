import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/6/12 21:30
 *
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */


public class Solution143 {

	//解法1 将链表拷贝到数组中,利用双指针实现
	public void reorderList(ListNode head) {

		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		List<ListNode> list = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur);
			cur = cur.next;
		}
		int i = 0;
		int j = list.size()-1;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		cur = dummy;
		while (i<j){
			cur.next = list.get(i);
			cur = cur.next;
			cur.next = list.get(j);
			cur = cur.next;
			i++;
			j--;
		}
		if (i == j) {
			cur.next = list.get(i);
			cur = cur.next;
		}
		cur.next = null;
	}

	public static void main(String[] args) {
		ListNode head = LinkedList.create(new int[]{1, 2, 3, 4,5});
		LinkedList.print(head);
		new Solution143().reorderList(head);
		LinkedList.print(head);
	}

}
