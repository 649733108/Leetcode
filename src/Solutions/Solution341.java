package Solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wxn
 * 2019/6/12 23:19
 * <p>
 * 341. 扁平化嵌套列表迭代器
 * <p>
 * 给定一个嵌套的整型列表。设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * <p>
 * 列表中的项或者为一个整数，或者是另一个列表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 * <p>
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,4,6]。
 */


public class Solution341 {


	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public class NestedIterator implements Iterator<Integer> {

		List<Integer> list = new ArrayList<>();
		int index = 0;

		public NestedIterator(List<NestedInteger> nestedList) {
			init(nestedList);
		}

		private void init(List<NestedInteger> nestedList) {
			for (NestedInteger nestedInteger : nestedList) {
				if (nestedInteger.isInteger()) {
					list.add(nestedInteger.getInteger());
				}else {
					init(nestedInteger.getList());
				}
			}
		}

		@Override
		public Integer next() {
			return list.get(index++);

		}

		@Override
		public boolean hasNext() {

			return index<list.size();
		}
	}
}
