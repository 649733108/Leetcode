import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/5/28 20:59
 * <p>
 * 147. 对链表进行插入排序
 * <p>
 * 对链表进行插入排序。
 * <p>
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * <p>
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */


public class Solution147 {

	public ListNode insertionSortList(ListNode head) {

		if (head == null) {
			return head;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val <= cur.next.val) {
				cur = cur.next;
				continue;
			}
			ListNode pre = dummyHead;
			ListNode temp = pre.next;
			while (temp != cur.next) {
				if (cur.next.val < temp.val) {
					ListNode t = cur.next;
					cur.next = cur.next.next;
					t.next = temp;
					pre.next = t;
					LinkedList.print(dummyHead.next);
					break;
				} else {
					pre = pre.next;
					temp = temp.next;
				}
			}
		}

		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode head = LinkedList.create(new int[]{4,2,1,3});
		System.out.println("原链表:");
		LinkedList.print(head);
		ListNode newHead = new Solution147().insertionSortList(head);
		System.out.println("新链表: ");
		LinkedList.print(newHead);
	}

}
