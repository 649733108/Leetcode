package Solutions;
/*
 * Created by wxn
 * 2018/8/14 13:32
 */

import java.util.TreeMap;

/**
 * 677. 键值映射
 *
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 */
public class Solution677 {
	static class MapSum {

		private class Node{
			boolean isWord;
			int value;
			TreeMap<Character , Node> next;

			public Node(boolean isWord , int value){
				this.isWord = isWord;
				this.value = value;
				next = new TreeMap<>();
			}
			public Node(){
				this(false,0);
			}
		}

		private Node root;

		/** Initialize your data structure here. */
		public MapSum() {
			root = new Node();
		}

		public void insert(String key, int val) {

			Node cur = root;

			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				if (!cur.next.containsKey(c)){
					cur.next.put(c,new Node());
				}
				cur = cur.next.get(c);
			}
			cur.isWord = true;
			cur.value = val;
		}

		public int sum(String prefix) {
			Node cur = root ;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (!cur.next.containsKey(c))
					return 0;
				cur = cur.next.get(c);
			}
			return sum(cur);
		}
		private int sum(Node node){
			int sum = 0;
			if (node.isWord){
				sum = sum + node.value;
			}
			for (char nextChar : node.next.keySet()){
				sum = sum + sum(node.next.get(nextChar));
			}
			return sum;
		}
	}

	public static void main(String args[]) {
		MapSum mapSum = new MapSum();
		mapSum.insert("apple",3);
		System.out.println(mapSum.sum("app"));
		mapSum.insert("app",2);
		System.out.println(mapSum.sum("app"));
	}

}
