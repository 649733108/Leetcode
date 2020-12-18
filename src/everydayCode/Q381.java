package everydayCode;

import java.util.*;

/**
 * Created by wxn
 * 2020/10/31 17:14
 */


public class Q381 {
	class RandomizedCollection {

		//set存放val在list中的下标
		public Map<Integer, Set<Integer>> map;
		public List<Integer> list;

		/**
		 * Initialize your data structure here.
		 */
		public RandomizedCollection() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
		 */
		public boolean insert(int val) {

			list.add(val);
			Set<Integer> indexSet = map.getOrDefault(val, new HashSet<>());
			indexSet.add(list.size() - 1);
			map.put(val, indexSet);
			return indexSet.size() == 1;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection contained the specified element.
		 */
		public boolean remove(int val) {

			if (!map.containsKey(val)){
				return false;
			}
			Set<Integer> indexSet = map.get(val);
			Integer i = indexSet.iterator().next();
			int lastNum = list.get(list.size()-1);
			list.set(i, lastNum);
			indexSet.remove(i);
			map.get(lastNum).remove(list.size()-1);
			if (i<list.size()-1){
				map.get(lastNum).add(i);
			}
			if (indexSet.isEmpty()){
				map.remove(val);
			}
			list.remove(list.size()-1);
			return true;
		}

		/**
		 * Get a random element from the collection.
		 */
		public int getRandom() {
			return list.get((int)(Math.random()*list.size()));
		}
	}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
