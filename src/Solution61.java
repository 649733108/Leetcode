import utils.linkedlist.ListNode;

/**
 * Created by wxn
 * 2019/6/10 13:31
 *
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution61 {

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k == 0) {
			return head;
		}

		int length = 0;
		ListNode cur = head;
		ListNode tail = null;
		while (cur != null) {
			length++;
			if (cur.next == null) {
				tail = cur;
			}
			cur = cur.next;
		}
		if (k >= length) {
			k = k%length;
		}
		if (k == 0) {
			return head;
		}
		cur = head;
		for (int i = 1; i < length-k; i++) {
			cur = cur.next;
		}
		ListNode newHead = cur.next;
		cur.next = null;
		tail.next = head;
		return newHead;

	}
}
