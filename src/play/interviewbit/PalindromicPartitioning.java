package play.interviewbit;

import java.util.ArrayList;

public class PalindromicPartitioning {
	public static ArrayList<ArrayList<String>> partition(String a) {
	    int n = a.length();
	    ArrayList<ArrayList<String>> ret = new ArrayList<>();
	    if (n == 0) {
	        ret.add(new ArrayList<String>());
	        return ret;
	    } else if (n == 1) {
	        ArrayList<String> iList   = new ArrayList<String>();
	        iList.add(a);
	        ret.add(iList);
	        return ret;
	    }
	    
	    ArrayList<String> part = new ArrayList<String>();
	    partition(a , 0 , part, ret);
	    
	    return ret;
	}
	
	private static boolean isPalin(String a) {
	    int n = a.length();
	    if (n <= 1) {
	        return true;
	    }
	    
	    for (int i = 0; i < n>>1 ; i++) {
	        if (a.charAt(i) != a.charAt(n - i -1)) {
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	private static void partition (String a, int start, ArrayList<String> part, 
	    ArrayList<ArrayList<String>> ret) {
	    
	    if (start == a.length()) {
	        ret.add(new ArrayList<String>(part));
	    }
	    
	    for (int i = start+1 ; i <= a.length(); i++) {
	        String sub = a.substring(start, i);
	        if (isPalin(sub)) {
	            part.add(sub);
	            partition (a, i , part, ret);
	            part.remove(part.size() - 1);
	        }
	        
	    }
	}
	
	public static void main(String[] args) {
		String ip	= "banana";
		System.out.println(partition(ip));
	}
}
