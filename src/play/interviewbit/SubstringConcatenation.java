package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringConcatenation {
	public static ArrayList<Integer> findSubstring(String a, final List<String> b) {
		int n = a.length();
		ArrayList<Integer> ret	= new ArrayList<>();
		int bufSize	= 0;
		
		if (n == 0) {
			return ret;
		}
		
		for (String str : b) {
		    bufSize += str.length();
		}
		if (n < bufSize) {
		    return ret;
		}
		
		Set<String> permutation	= new HashSet<>();
		ArrayList<ArrayList<String>> alPerm	= permute(new ArrayList<>(b));
		String key = null;
		
		for (ArrayList<String> al : alPerm) {
			key	= al.stream().reduce("" , String::concat);
			permutation.add(key);
		}
		
		
		
		bufSize	= key.length();
		String sub	= null;
		
		for (int i = 0 ; i < n - bufSize; i++ ) {
			sub	= a.substring(i , i+bufSize);
			if (permutation.contains(sub)) {
				ret.add(i);
			}
		}
		
		return ret;
	}
	
	public static ArrayList<ArrayList<String>> permute(ArrayList<String> a) {
	    int n   = a.size();
	    ArrayList<ArrayList<String>> ret   = new ArrayList<>();
	    
	    if (n <= 1){
	        ret.add(a);
	        return ret;
	    }
	    
	    permute(a, 0, ret); 
	    return ret;   
	}
	
	private static void permute (ArrayList<String> a, int start,ArrayList<ArrayList<String>> ret){
	    if (start >= a.size()) {
	        ArrayList<String> inst = new ArrayList<>(a);
	        ret.add(inst);
	    } 
    
        for (int j = start; j < a.size(); j++){
            swap (a, start, j);
            permute(a, start +1 , ret);
            swap (a, start, j);
        }
	}
	
	private static void swap (ArrayList<String> a, int x, int y) {
	    if (x == y)
	        return;
	    String t   = a.get(x);
	    a.set(x, a.get(y));
	    a.set(y, t);
	}
	
	public static void main(String[] args) {
		String s1	= "barfoothefoobarman";
		String[] l1	= {"foo","bar"};
		
		System.out.println(findSubstring(s1, Arrays.asList(l1)));
	}
}
