import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2020/12/7 19:28
 */


public class ReverseLinkedList1 {

	public ListNode reverse(ListNode head){
		if (head==null || head.next==null){
			return head;
		}
		ListNode dummyHead = null;
		ListNode cur = head;
		ListNode next ;
		while (cur!=null){
			next = cur.next;
			cur.next = dummyHead;
			dummyHead = cur;
			cur = next;
		}
		return dummyHead;
	}

	public ListNode curReverse(ListNode head){
		return curReverse(head,null);
	}

	private ListNode curReverse(ListNode cur, ListNode pre) {
		if (cur==null){
			return pre;
		}
		ListNode head = curReverse(cur.next, cur);
		cur.next = pre;
		return head;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4};
		ListNode head = LinkedList.create(nums);
		ListNode newHead = new ReverseLinkedList1().reverse(head);
		LinkedList.print(newHead);
	}
}
