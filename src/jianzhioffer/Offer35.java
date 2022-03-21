package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2021/9/14 15:27
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class Offer35 {
	//方法1 哈希表
	public Node copyRandomList(Node head) {

		Map<Node, Node> map = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			Node newNode = new Node(cur.val);
			map.put(cur, newNode);
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			Node copyNode = map.get(cur);
			copyNode.next = map.getOrDefault(cur.next, null);
			copyNode.random = map.getOrDefault(cur.random, null);
			cur = cur.next;
		}
		return map.get(head);
	}

	//方法2 在原节点后插入复制的节点，即为1->2->3->4->null 变为 1->1'->2->2'->3->3'->4->4'->null
	//不需要额外的空间
	public Node copyRandomList2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		while (cur != null) {
			Node newNode = new Node(cur.val);
			Node next = cur.next;
			cur.next = newNode;
			newNode.next = next;
			cur = cur.next.next;
		}
		cur = head;
		while (cur != null) {
			Node copyNode = cur.next;
			copyNode.random = cur.random == null ? null : cur.random.next;
			cur = cur.next.next;
		}

		//拆链
		Node newHead = head.next;
		cur = head;
		Node cur2 = newHead;
		while (cur != null && cur2!=null) {
			cur.next = cur2.next;
			cur2.next = cur2.next==null?null:cur2.next.next;
			cur = cur.next;
			cur2 = cur2.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		Offer35 o = new Offer35();
		Node head = new Node(7);
		o.copyRandomList2(head);
	}
}
