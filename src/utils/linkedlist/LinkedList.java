package utils.linkedlist;

/**
 * Created by wxn
 * 2019/4/22 20:33
 *
 * 链表
 */


public class LinkedList {

	/**
	 * 创建链表
	 * @param arr
	 * @return
	 */
	public static ListNode create(int[] arr){
		if (arr==null || arr.length==0){
			return null;
		}

		ListNode head = new ListNode(arr[0]);
		ListNode curNode = head;
		for (int i = 1; i < arr.length; i++) {
			curNode.next = new ListNode(arr[i]);
			curNode = curNode.next;
		}
		return head;
	}

	public static void print(ListNode head){
		ListNode curNode = head;
		while (curNode!=null){
			System.out.print(curNode.val + " -> ");
			curNode = curNode.next;
		}

		System.out.println("NULL");
	}
}
