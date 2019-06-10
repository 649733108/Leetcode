import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2019/6/10 14:01
 *
 * 138. 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。 
 *
 *
 * 示例：
 *
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *  
 *
 * 提示：
 *
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution138 {

	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {}

		public Node(int _val,Node _next,Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	}

	//利用map来保存新生成的节点和原节点的对应关系
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Map<Node,Node> map = new HashMap<>();
		Node newHead = new Node(head.val,null,null);
		Node node = newHead;
		Node cur = head.next;
		map.put(head, newHead);
		while (cur != null) {
			node.next = new Node(cur.val,null,null);
			map.put(cur, node.next);
			node = node.next;
			cur = cur.next;
		}
		node = newHead;
		cur = head;
		while (cur != null) {
			node.random = map.get(cur.random);
			node = node.next;
			cur = cur.next;
		}
		return newHead;
	}
}
