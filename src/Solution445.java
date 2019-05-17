import utils.linkedlist.LinkedList;
import utils.linkedlist.ListNode;

import java.math.BigDecimal;

/**
 * Created by wxn
 * 2019/4/30 17:46
 * <p>
 * 445.两数相加 II
 * <p>
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * <p>
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */


public class Solution445 {


	//解法1 将链表转换成数字再相加
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		BigDecimal num1 = new BigDecimal(0);
		BigDecimal num2 = new BigDecimal(0);
		while (l1 != null) {
			num1 = num1.multiply(new BigDecimal(10)).add(new BigDecimal(l1.val));
			l1 = l1.next;
		}
		while (l2 != null) {
			num2 = num2.multiply(new BigDecimal(10)).add(new BigDecimal(l2.val));
			l2 = l2.next;
		}
		BigDecimal sum = num1.add(num2);
		String s = String.valueOf(sum);
		ListNode dummyHead = new ListNode(-1);
		ListNode cur = dummyHead;
		for (int i = 0; i < s.length(); i++) {
			cur.next = new ListNode(Character.getNumericValue(s.charAt(i)));
			cur = cur.next;
		}
		return dummyHead.next;

	}

	public static void main(String args[]) {
		int[] arr1 = {7,2,4,3};
		int[] arr2 = {5,6,4};
		ListNode l1 = LinkedList.create(arr1);
		ListNode l2 = LinkedList.create(arr2);
		ListNode head = new Solution445().addTwoNumbers(l1, l2);
		LinkedList.print(head);
	}

}
