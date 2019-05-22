
/*
 * Created by wxn
 * 2019/4/1 21:18
 */

/**
 *
 * 92.反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution92 {

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;

		ListNode pre = dummyNode;
		ListNode cur = head;
		ListNode mNode = null;
		ListNode nNode = null;
		ListNode mPre = null;
		ListNode nNext = null;

		int index = 1;
		//寻找m点
		while (cur!=null && index<m){
			pre = cur;
			cur = cur.next;
			index++;
		}
		mNode = cur;
		mPre = pre;

		//寻找n点
		while (cur!=null && index<=n){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			index++;
		}
		nNode = pre;
		nNext = cur;
		mPre.next = nNode;
		if (mNode!=null){
			mNode.next = nNext;
		}

		return dummyNode.next;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		new Solution92().reverseBetween(head,1,2);
	}

}
