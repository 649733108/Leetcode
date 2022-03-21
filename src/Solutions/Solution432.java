package Solutions;

import java.util.*;

/**
 * Created by wxn
 * 2022/3/16 20:02
 * <p>
 * 请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。
 * <p>
 * 实现 AllOne 类：
 * <p>
 * AllOne() 初始化数据结构的对象。
 * inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
 * dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。
 * getMaxKey() 返回任意一个计数最大的字符串。如果没有元素存在，返回一个空字符串 "" 。
 * getMinKey() 返回任意一个计数最小的字符串。如果没有元素存在，返回一个空字符串 "" 。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
 * [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
 * 输出
 * [null, null, null, "hello", "hello", null, "hello", "leet"]
 * <p>
 * 解释
 * AllOne allOne = new AllOne();
 * allOne.inc("hello");
 * allOne.inc("hello");
 * allOne.getMaxKey(); // 返回 "hello"
 * allOne.getMinKey(); // 返回 "hello"
 * allOne.inc("leet");
 * allOne.getMaxKey(); // 返回 "hello"
 * allOne.getMinKey(); // 返回 "leet"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length <= 10
 * key 由小写英文字母组成
 * 测试用例保证：在每次调用 dec 时，数据结构中总存在 key
 * 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 5 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Solution432 {

//	class AllOne {
//
//		Map<String, Integer> map;
//		PriorityQueue<String> maxQ;
//		PriorityQueue<String> minQ;
//
//		public AllOne() {
//			map = new HashMap<>();
//			maxQ = new PriorityQueue<>(((o1, o2) -> map.get(o2) - map.get(o1)));
//			minQ = new PriorityQueue<>(((o1, o2) -> map.get(o1) - map.get(o2)));
//		}
//
//		public void inc(String key) {
//			map.put(key, map.getOrDefault(key, 0) + 1);
//			if (!maxQ.contains(key)) {
//				maxQ.add(key);
//			} else {
//				maxQ.remove(key);
//				maxQ.add(key);
//			}
//			if (!minQ.contains(key)) {
//				minQ.add(key);
//			} else {
//				minQ.remove(key);
//				minQ.add(key);
//			}
//		}
//
//		public void dec(String key) {
//			if (map.get(key) == 1) {
//				map.remove(key);
//				maxQ.remove(key);
//				minQ.remove(key);
//			} else {
//				map.put(key, map.get(key) - 1);
//				maxQ.remove(key);
//				maxQ.add(key);
//				minQ.remove(key);
//				minQ.add(key);
//			}
//		}
//
//		public String getMaxKey() {
//
//			if (map.isEmpty()) {
//				return "";
//			}
//			return maxQ.peek();
//		}
//
//		public String getMinKey() {
//			if (map.isEmpty()) {
//				return "";
//			}
//			return minQ.peek();
//		}
//	}


	class AllOne {

		class Node{
			Set<String> set;
			int count;
			Node prev;
			Node next;
			public Node(String key, int count){
				set = new HashSet<>();
				set.add(key);
				this.count = count;
			}
		}

		Map<String ,Node> map;
		Node head;
		Node tail;

		public AllOne() {

			map = new HashMap<>();
			//创建虚拟头节点和虚拟尾节点
			head = new Node("",-1);
			tail = new Node("", -1);
			head.next = tail;
			tail.prev = head;
		}

		public void inc(String key) {

			if (!map.containsKey(key)){
				if(head.next.count>1 || head.next.count==-1){
					Node next = head.next;
					Node node = new Node(key,1);
					head.next = node;
					node.next = next;
					node.prev = head;
					next.prev = node;
				} else if (head.next.count == 1) {
					head.next.set.add(key);
				}
				map.put(key,head.next);
			}else {
				Node node = map.get(key);
				if (node.next.count==node.count+1){
					node.next.set.add(key);
				}else {
					Node newNode = new Node(key,node.count+1);
					newNode.next = node.next;
					node.next.prev = newNode;
					node.next = newNode;
					newNode.prev = node;
				}
				node.set.remove(key);
				map.put(key,node.next);
				if (node.set.isEmpty()) {
					node.prev.next = node.next;
					node.next.prev = node.prev;
					node.prev = null;
					node.next = null;
				}
			}
		}

		public void dec(String key) {
			Node node = map.get(key);
			if (node.count==1){

			}
			else if (node.prev.count!=node.count-1){
				Node newNode = new Node(key,node.count-1);
				node.prev.next = newNode;
				newNode.prev = node.prev;
				newNode.next = node;
				node.prev = newNode;
			}else {
				node.prev.set.add(key);
			}

			node.set.remove(key);
			map.put(key,node.prev);
			if (node.set.isEmpty()) {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node.prev = null;
				node.next = null;
			}
			if (node.count==1){
				map.remove(key);
			}
		}

		public String getMaxKey() {
			if (tail.prev.count != -1) {
				for (String key : tail.prev.set) {
					return key;
				}
			}
			return "";
		}

		public String getMinKey() {
			if (head.next.count == -1) {
				return "";
			}
			for (String key:head.next.set){
				return key;
			}
			return "";
		}
	}


	//["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
//		[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
	public void fun() {
		AllOne allOne = new AllOne();
		allOne.inc("a");
		allOne.inc("b");
		allOne.inc("b");
		allOne.inc("c");
		allOne.inc("c");
		allOne.inc("c");
		allOne.dec("b");
		allOne.dec("b");
		System.out.println(allOne.getMinKey());
		allOne.dec("a");
		System.out.println(allOne.getMaxKey());
		System.out.println(allOne.getMinKey());
	}

	public static void main(String[] args) {
		Solution432 s = new Solution432();
		s.fun();
	}
}
