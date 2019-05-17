import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/4/22 22:43
 * <p>
 * 83.删除排序链表中的重复元素
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */


public class Solution83 {


	public ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode curNode = head;
		while (curNode!=null &&curNode.next!=null){
			if (curNode.next.val==curNode.val){
				curNode.next = curNode.next.next;
			}else {
				curNode = curNode.next;
			}

		}
		return head;

	}

	public static void main(String args[]) {
		int[] arr = {1,1,2,2,3,3,3,3};
		ListNode head = LinkedList.create(arr);
		LinkedList.print(head);
		new Solution83().deleteDuplicates(head);
		LinkedList.print(head);
	}

}

