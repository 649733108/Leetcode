import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/5/28 20:58
 *
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */


public class Solution25 {

	/**
	 * 这道题让我们以每k个为一组来翻转链表，实际上是把原链表分成若干小段，
	 * 然后分别对其进行翻转，那么肯定总共需要两个函数，一个是用来分段的，
	 * 一个是用来翻转的，我们就以题目中给的例子来看，对于给定链表 1->2->3->4->5
	 * ，一般在处理链表问题时，我们大多时候都会在开头再加一个 dummy node，
	 * 因为翻转链表时头结点可能会变化，为了记录当前最新的头结点的位置而引入的 dummy node，
	 * 那么我们加入 dummy node 后的链表变为 -1->1->2->3->4->5，如果k为3的话，
	 * 我们的目标是将 1,2,3 翻转一下，那么我们需要一些指针，
	 * pre 和 next 分别指向要翻转的链表的前后的位置，
	 * 然后翻转后 pre 的位置更新到如下新的位置：
	 * <p>
	 * -1->1->2->3->4->5
	 * |        |  |
	 * pre      cur next
	 * <p>
	 * -1->3->2->1->4->5
	 * |     |  |
	 * cur   pre next
	 *
	 * 以此类推，只要 cur 走过k个节点，那么 next 就是 cur->next，
	 * 就可以调用翻转函数来进行局部翻转了，注意翻转之后新的 cur 和 pre 的位置都不同了，
	 * 那么翻转之后，cur 应该更新为 pre->next，而如果不需要翻转的话，cur 更新为 cur->next
	 */
	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || k <= 1) {
			return head;
		}

		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		ListNode cur = head;

		for (int i = 1; cur != null; i++) {
			if (i % k == 0) {
				pre = reverseOneGroup(pre, cur.next);
				cur = pre.next;
			}else {
				cur = cur.next;
			}
		}
		return dummyHead.next;
	}

	//反转链表
	private ListNode reverseOneGroup(ListNode pre, ListNode next) {
		ListNode last = pre.next, cur = last.next;
		while(cur != next) {
			last.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = last.next;
		}
		return last;
	}

	/**
	 * 递归
	 * 我们用 head 记录每段的开始位置，cur 记录结束位置的下一个节点，
	 * 然后我们调用 reverse 函数来将这段翻转，然后得到一个 new_head，
	 * 原来的 head 就变成了末尾，这时候后面接上递归调用下一段得到的新节点，
	 * 返回 new_head 即可
	 */
	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode cur = head;
		for (int i = 0; i < k; i++) {
			if (cur == null) {
				return head;
			}
			cur = cur.next;
		}
		ListNode new_head = reverse(head,cur);
		head.next = reverseKGroup2(cur, k);
		return new_head;

	}

	private ListNode reverse(ListNode head, ListNode tail) {

		ListNode pre = tail;
		while (head != tail) {
			ListNode t = head.next;
			head.next = pre;
			pre = head;
			head = t;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode head = LinkedList.create(new int[]{1, 2, 3, 4, 5});
		ListNode ret = new Solution25().reverseKGroup2(head, 3);
		LinkedList.print(ret);
	}

}
