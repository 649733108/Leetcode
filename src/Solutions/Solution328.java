package Solutions;

import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/4/30 17:08
 *
 * 328.奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */


public class Solution328 {


	//解法1 使用两个临时链表 一个保存奇数 一个保存偶数
	public ListNode oddEvenList(ListNode head) {

		ListNode dummyNode1 = new ListNode(-1);
		ListNode dummyNode2 = new ListNode(-1);
		ListNode prve1 = dummyNode1;
		ListNode prve2 = dummyNode2;

		ListNode curNode = head;
		int i = 1;
		while (curNode!=null){
			if (i%2!=0){
				//奇数
				prve1.next = curNode;
				prve1 = prve1.next;
			}else {
				//偶数
				prve2.next = curNode;
				prve2 = prve2.next;
			}
			curNode = curNode.next;
			i++;
		}
		prve1.next = dummyNode2.next;
		prve2.next = null;
		return dummyNode1.next;
	}

	//解法2 不使用额外的空间
	// 我们可以使用两个指针来做，pre指向奇节点，cur指向偶节点，
	// 然后把偶节点cur后面的那个奇节点提前到pre的后面，
	// 然后pre和cur各自前进一步，此时cur又指向偶节点，
	// pre指向当前奇节点的末尾，以此类推直至把所有的偶节点都提前了即可
	public ListNode oddEvenList2(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur!=null && cur.next!=null){
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
			pre = pre.next;
			cur = cur.next;
		}
		return head;

	}

	public static void main(String args[]) {
		int[] arr = {1, 2, 3, 4, 5};
		ListNode head = LinkedList.create(arr);
		LinkedList.print(head);
		head = new Solution328().oddEvenList2(head);
		LinkedList.print(head);
	}

}
