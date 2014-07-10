package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhf
 * @email zhf.thu@gmail.com
 * @version 创建时间：2014年7月10日 下午6:19:31
 * reference:http://www.importnew.com/11493.html
 */
public class FirstNonRepeatedCharacter {
	public static void main(String[] args) {
		char c = find4("hello");
		System.out.println(c);
	}

	public static char find4(String s){
		char ch;
		int index = 0;
		for(int i=0;i<s.length();i++){
			ch = s.charAt(i);
			index = s.indexOf(ch);
			if(index >= 0 && s.indexOf(ch,index+1) >= 0){
				if(i == s.length() - 1)
					System.out.println("not found.");
			}else{
				return ch;
			}
		}
		return ' ';
	}
	/**
	 * 扫描字符串并将每个字符的出现次数保存在HashMap中 遍历字符串并从Map中获取每个字符的个数
	 * 由于我们从左往右扫描字符，当找到某个字符的计数为1时，我们就可以跳出循环，它就是第一个非重复的字符。
	 *  在这里，字符次序是靠再次遍历源字符串来实现。
	 */
	public static char find3(String s){
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if(map.get(ch) == 1)
				return ch;
		}
		return ' ';
	}
	/**
	 * 一次字符串扫描中找到第一个不重复的字符，它应用了典型的空间时间权衡技术。
	 * 它使用了两个存储空间来减少一次循环，是标准的空间-时间折衷。
	 * 由于我们将重复和不重复的字符分开存放，在循环结束后，
	 * 存放不重复字符的列表中的第一个元素就是我们所要找的第一个非重复字符。
	 */
	public static char find2(String s) {
		int len = s.length();
		Set<Character> repeating = new HashSet<Character>();
		List<Character> nonRepeating = new ArrayList<Character>();
		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if (repeating.contains(ch))
				continue;
			if (nonRepeating.contains(ch)) {
				nonRepeating.remove((Character)ch);
				repeating.add(ch);
			} else
				nonRepeating.add(ch);
		}
		return nonRepeating.get(0);

	}
	//LinkedHashMap是按照放入的顺序取出的
	public static char find1(String s) {
		int len = s.length();
		if(len <= 1)
			return ' ';
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<len;i++){
			if(map.get(s.charAt(i)) == null)
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.get(s.charAt(i) + 1));
		}
		for(Map.Entry<Character, Integer> m : map.entrySet())
			if(m.getValue() == 1)
				return m.getKey();
		return ' ';
	}
}
