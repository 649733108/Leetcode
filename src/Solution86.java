import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/4/30 15:42
 *
 * 86.分割链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */


public class Solution86 {


	//解法1.找到第一个>=给定值的节点(如例中的4),以后每遇到一个小于给定值的节点,就把它放到4的前面
	public ListNode partition(ListNode head, int x) {

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode preNode = dummyNode;
		ListNode curNode = head;

		//找到<x的最后一个节点 此时pre = 这个节点
		while (preNode.next != null && preNode.next.val < x) {
			preNode = preNode.next;
		}
		curNode = preNode;
		while (curNode.next!=null){
			if (curNode.next.val < x) {
				ListNode tempNode = curNode.next;
				curNode.next = tempNode.next;
				tempNode.next = preNode.next;
				preNode.next = tempNode;
				preNode = tempNode;
			}else {
				curNode = curNode.next;
			}
		}
		return dummyNode.next;
	}

	//解法2 将所有小于给定值的节点组成一个新链表并从原列表中删除,最后将原列表接在新链表的后面
	public ListNode partition2(ListNode head, int x) {

		//记录小于给定值的链表
		ListNode dummyNode1 = new ListNode(-1);
		//记录大于给定值的链表
		ListNode dummyNode2 = new ListNode(-1);

		ListNode prev1 = dummyNode1;
		ListNode prev2 = dummyNode2;
		ListNode cur = head;

		while (cur!=null){
			if (cur.val<x){
				prev1.next = cur;
				prev1 = prev1.next;
				cur = cur.next;
			}else {
				prev2.next = cur;
				prev2 = prev2.next;
				cur = cur.next;
			}
		}
		prev1.next = dummyNode2.next;
		prev2.next = null;
		return dummyNode1.next;
	}


	public static void main(String args[]) {
		int[] arr = {1,4,3,2,5,2};
		ListNode head = LinkedList.create(arr);
		LinkedList.print(head);
		head = new Solution86().partition2(head, 3);
		LinkedList.print(head);
	}

}
