import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/5/28 21:00
 *
 * 148. 排序链表
 *
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */


public class Solution148 {


	//利用归并排序的思想
	public ListNode sortList(ListNode head) {

		if (head==null || head.next==null){
			return head;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head2 = slow.next;
		slow.next = null;

		head = sortList(head);
		head2 = sortList(head2);

		return merge(head,head2);

	}

	private ListNode merge(ListNode head, ListNode head2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (head!=null && head2!=null){
			if (head.val<head2.val){
				cur.next = head;
				head = head.next;
			}else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		if (head!=null){
			cur.next = head;
		}
		if (head2!=null){
			cur.next = head2;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedList.create(new int[]{-1,5,3,4,0});
		LinkedList.print(head);
		ListNode new_head = new Solution148().sortList(head);
		LinkedList.print(new_head);

	}

}
