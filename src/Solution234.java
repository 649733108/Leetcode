import utils.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wxn
 * 2019/6/12 21:31
 * <p>
 * 234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */


public class Solution234 {

	//解法1 把链表放到数组里 用双指针判断
	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null) {
			return true;
		}

		List<Integer> list = new ArrayList<>();
		ListNode cur = head;
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		int i = 0;
		int j = list.size()-1;
		while (i<j){
			if (!list.get(i).equals(list.get(j))) {
				return false;
			}else {
				i++;
				j--;
			}
		}
		return true;
	}

	//解法2 利用快慢指针找到链表的中点,利用栈判断是否回文
	public boolean isPalindrome2(ListNode head){
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		Stack<Integer> stack = new Stack<>();
		stack.push(slow.val);
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			stack.push(slow.val);
		}
		if (fast == null) {
			stack.pop();
		}
		slow = slow.next;
		while (slow != null) {
			if (slow.val!=stack.pop()){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	//解法3 找到中点后,把后半段指针翻转过来,就可以不用栈了
	public boolean isPalindrome3(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;

		ListNode pre = null;
		ListNode next = null;
		while (newHead!=null){
			next = newHead.next;
			newHead.next = pre;
			pre = newHead;
			newHead = next;
		}
		newHead = pre;
		slow = head;
		while (newHead != null) {
			if (newHead.val!=slow.val){
				return false;
			}
			newHead = newHead.next;
			slow = slow.next;
		}
		return true;
	}
}
