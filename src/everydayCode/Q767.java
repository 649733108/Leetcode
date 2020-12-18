package everydayCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wxn
 * 2020/11/30 19:35
 */


public class Q767 {

	public String reorganizeString(String S) {

		int[]counts = new int[26];
		int maxCount = 0;
		for (int i = 0; i < S.length(); i++) {
			counts[S.charAt(i)-'a']++;
			maxCount = Math.max(maxCount, counts[S.charAt(i)-'a']);
		}
		if (maxCount>(S.length()+1)/2){
			return "";
		}
		PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return counts[c2-'a']-counts[c1-'a'];
			}
		});
		for (int i = 0; i < 26; i++) {
			if (counts[i]>0){
				priorityQueue.add((char)('a'+i));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (priorityQueue.size()>1){
			char c1 = priorityQueue.poll();
			char c2 = priorityQueue.poll();
			sb.append(c1);
			sb.append(c2);
			counts[c1-'a']--;
			counts[c2-'a']--;
			if (counts[c1-'a']>0){
				priorityQueue.add(c1);
			}
			if (counts[c2-'a']>0){
				priorityQueue.add(c2);
			}
		}
		if (priorityQueue.size()>0){
			sb.append(priorityQueue.peek());
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		new Q767().reorganizeString("aab");
	}
}
