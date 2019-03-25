
/*
 * Created by wxn
 * 2019/3/24 18:31
 */

import java.util.*;

/**
 * 451.根据字符出现频率排序
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class Solution451 {

    //暴力法
    public String frequencySort(String s) {

	Map<Character,Integer>map = new HashMap<>();
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 0; i < s.length(); i++) {
	    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
	}
	while (map.size()>0){
	    int count = 0;
	    char c = ' ';
	    for (Character character : map.keySet()) {
		if (map.get(character)>count) {
		    count = map.get(character);
		    c = character;
		}
	    }
	    for (int i = 0; i < count; i++) {
		stringBuilder.append(c);
	    }
	    map.remove(c);
	}
	return stringBuilder.toString();

    }


    //使用优先队列
    public String frequencySort2(String s) {

	PriorityQueue<Letter>priorityQueue = new PriorityQueue<>((o1, o2) -> o2.freq-o1.freq);
	Map<Character,Integer>map = new HashMap<>();
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 0; i < s.length(); i++) {
	    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
	}
	for (Character character : map.keySet()) {
	    priorityQueue.add(new Letter(character,map.get(character)));
	}
	while (priorityQueue.size()>0){
	    Letter letter = priorityQueue.remove();
	    for (int i = 0; i < letter.freq; i++) {
		stringBuilder.append(letter.letter);
	    }
	}
	return stringBuilder.toString();
    }

    //使用list
    public String frequencySort3(String s) {

	Map<Character,Integer>map = new HashMap<>();
	StringBuilder stringBuilder = new StringBuilder();
	List<Letter>letters = new ArrayList<>();
	for (int i = 0; i < s.length(); i++) {
	    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
	}
	for (Character character : map.keySet()) {
	    letters.add(new Letter(character,map.get(character)));
	}
	letters.sort((o1, o2) -> o2.freq - o1.freq);
	for (Letter letter : letters) {
	    for (int i = 0; i < letter.freq; i++) {
		stringBuilder.append(letter.letter);
	    }
	}

	return stringBuilder.toString();
    }

    private class Letter{
        private char letter;
        private int freq;

	private Letter(char letter, int freq) {
	    this.letter = letter;
	    this.freq = freq;
	}
    }

    //使用桶排序
    @SuppressWarnings("unchecked")
    public String frequencySort4(String s){

	Map<Character,Integer>map = new HashMap<>();
	StringBuilder stringBuilder = new StringBuilder();
	ArrayList<Character>[] lists = new ArrayList[s.length()+1];
	for (int i = 0; i < s.length(); i++) {
	    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
	}
	for (Character character : map.keySet()) {
	    int value = map.get(character);
	    if (lists[value]==null){
	        lists[value] = new ArrayList();
	    }
	    lists[value].add(character);
	}
	for (int i = lists.length-1 ; i>0 ; i--){
	    if (lists[i]==null){
	        continue;
	    }
	    for (Character character : lists[i]) {
		for (int j = 0 ; j<i; j++){
		    stringBuilder.append(character);
		}
	    }
	}
	return stringBuilder.toString();
    }


    public static void main(String args[]) {
	System.out.println(new Solution451().frequencySort4("tree"));
    }

}
