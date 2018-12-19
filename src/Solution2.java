
/*
 * Created by wxn
 * 2018/8/10 6:07
 */

/**
 * 2. 两数相加
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		ListNode(int x, ListNode next) {
			val = x;
			this.next = next;
		}

	}

//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//
//		StringBuilder stringBuilder1 = new StringBuilder();
//		StringBuilder stringBuilder2 = new StringBuilder();
//		while (l1 != null) {
//			stringBuilder1.insert(0,l1.val);
//			l1 = l1.next;
//		}
//		while (l2 != null) {
//			stringBuilder2.insert(0,l2.val);
//			l2 = l2.next;
//		}
//		long res = Long.valueOf(stringBuilder1.toString())+Long.valueOf(stringBuilder2.toString());
//		String str = String.valueOf(res);
//		ListNode head = null;
//		for (int i = 0; i <  str.length()  ;i++){
//			ListNode node = new ListNode(str.charAt(i)-48);
//			node.next = head;
//			head = node;
//		}
//		return head;
//	}


	/**
	 * 新的尝试
	 */
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		ListNode head = null;
//
//		int jinwei = 0;
//		while (l1 != null || l2 != null) {
//			if (l1 != null && l2 != null) {
//				int sum = l1.val + l2.val + jinwei;
//				if (sum > 9) {
//					jinwei = 1;
//					sum -= 10;
//				} else {
//					jinwei = 0;
//				}
//				ListNode node = new ListNode(sum);
//				if (head == null) {
//					head = node;
//				} else {
//					ListNode node1 = head;
//					while (node1.next != null) {
//						node1 = node1.next;
//					}
//					node1.next = node;
//				}
//			}
//			if (l1 == null) {
//				int sum = jinwei + l2.val;
//				if (sum > 9) {
//					jinwei = 1;
//					sum -= 10;
//				} else {
//					jinwei = 0;
//				}
//				ListNode node = new ListNode(sum);
//				if (head == null) {
//					head = node;
//				} else {
//					ListNode node1 = head;
//					while (node1.next != null) {
//						node1 = node1.next;
//					}
//					node1.next = node;
//				}
//			}
//			if (l2 == null) {
//				int sum = jinwei + l1.val;
//				if (sum > 9) {
//					jinwei = 1;
//					sum -= 10;
//				} else {
//					jinwei = 0;
//				}
//				ListNode node = new ListNode(sum);
//				if (head == null) {
//					head = node;
//				} else {
//					ListNode node1 = head;
//					while (node1.next != null) {
//						node1 = node1.next;
//					}
//					node1.next = node;
//				}
//			}
//			if (l1 != null) {
//				l1 = l1.next;
//			}
//			if (l2 != null) {
//				l2 = l2.next;
//			}
//		}
//		if (jinwei == 1) {
//			ListNode node = new ListNode(1);
//			ListNode node1 = head;
//			while (node1.next != null) {
//				node1 = node1.next;
//			}
//			node1.next = node;
//
//		}
//
//		return head;
//	}


	/**
	 * 官方解答
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(-1);
		ListNode p = l1, q = l2;
		ListNode cur = dummyHead;
		int jinwei = 0; //进位符
		while (p != null || q != null) {
			int x = p == null ? 0 : p.val;
			int y = q == null ? 0 : q.val;
			int sum = x + y + jinwei ;
			jinwei = sum/10;
			cur.next = new ListNode(sum%10);
			cur = cur.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}

		}
		if (jinwei!=0){
			cur.next = new ListNode(1);
		}
		return dummyHead.next;
	}


	public static void main(String args[]) {
		ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

//		ListNode n1 = new ListNode(9, null);
//		ListNode n2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(4, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));

		Solution2 solution2 = new Solution2();
		solution2.addTwoNumbers(n1, n2);
	}


}
