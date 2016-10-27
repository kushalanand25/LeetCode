package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationSol2 {
	public ArrayList<Integer> findSubstring(String A, final List<String> B) {

		ArrayList<Integer> res = new ArrayList<>();

		if (A == null || B == null || B.size() == 0 || A.length() == 0)
			return res;

		HashMap<String, Integer> words = new HashMap<>();
		int len = 0;

		for (String str : B) {
			int val = 1;
			if (words.containsKey(str)) {
				val = words.get(str) + 1;
			}
			words.put(str, val);
			len = str.length();
		}

		int size = B.size();
		int index;

		for (int i = 0; i <= A.length() - len * size; i++) {

			index = i;
			int loop = size;
			HashMap<String, Integer> hashMap = new HashMap<>(words);

			for (int j = 0; j < loop; j++) {
				String str = A.substring(index + j * len, index + j * len + len);
				if (hashMap.containsKey(str)) {
					int val = hashMap.get(str);
					if (val == 1) {
						hashMap.remove(str);
					} else {
						hashMap.put(str, val - 1);
					}
				} else {
					break;
				}
			}

			if (hashMap.isEmpty()) {
				res.add(i);
			}

		}

		return res;

	} 
	
	public static void main(String[] args) {
		String s1	= "barfoothefoobarman";
		String[] l1	= {"foo","bar"};
		
		System.out.println(new SubstringConcatenationSol2().findSubstring(s1, Arrays.asList(l1)));
	}
}
