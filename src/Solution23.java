import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/6/10 11:17
 *
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution23 {

	//解法1 暴力两两合并
	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		ListNode node1 = lists[0];
		for (int i = 1; i < lists.length; i++) {
			ListNode node2 = lists[i];
			node1 = merge(node1, node2);
		}
		return node1;

	}


	//合并两个有序链表,返回合并后的头结点
	private ListNode merge(ListNode node1, ListNode node2) {
		if (node1 == null){
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		if (node1.val<node2.val){
			node1.next = merge(node1.next, node2);
			return node1;
		}else {
			node2.next = merge(node2.next, node1);
			return node2;
		}
	}

	//解法2 分治两两合并
	public ListNode mergeKLists2(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		int begin = 0;
		int end = lists.length-1;
		while (end > 0) {
			begin = 0;
			while (begin < end) {
				lists[begin] = merge(lists[begin],lists[end]);
				begin++;
				end--;
			}
		}
		return lists[0];
	}

	public static void main(String[] args) {
		ListNode node1 = LinkedList.create(new int[]{1, 4, 5});
		ListNode node2 = LinkedList.create(new int[]{1, 3, 4});
		ListNode node3 = LinkedList.create(new int[]{2, 6});

		ListNode[] lists = new ListNode[]{node1,node2,node3};

		ListNode head = new Solution23().mergeKLists2(lists);

		LinkedList.print(head);
	}

}
