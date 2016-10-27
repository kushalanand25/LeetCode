package play.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNum {
	// DO NOT MODIFY THE LIST
	public static String largestNumber(final List<Integer> a) {
	    StringBuilder sb = new StringBuilder();
	    int max = Integer.MIN_VALUE;
	    int digits = 0;
	    List<String> list = new ArrayList<>();
	    
	    for(int x : a){
	        max = Math.max(max, x);
	        list.add(Integer.toString(x));
	    }
	    
	    for(int n = max; n >0 ; n= n/10){
	        digits++;
	    }
	    
	   // System.out.println(max +","+ digits);
	   
	   // radix sort
	   for(int d = 1; d <= digits; d++){
	       list = countSort(list, d);
	       System.out.println(list);
	   }
	   
	    
	    for(String str : list){
	        sb.append(str);
	    }
	    
	    return sb.toString();
	}
	
	private static List<String> countSort(List<String> list, int idx){
	    List<String> ret = new ArrayList<>(Collections.nCopies(list.size(), ""));
	    int[] count = new int[10];
	    
	    for(String str : list){
    		count[str.length() >=  idx ? str.charAt(idx -1) - '0' : 0]++;
	    }
	    
	    for(int i = 1; i < 10; i++){
	    	count[i] += count[i-1];
	    }
	    
	    for(int i = list.size() - 1; i >= 0; i--){
	    	String str = list.get(i);
	    	int r = str.length() >=  idx ? str.charAt(idx -1) - '0' : 0;
	    	ret.set(count[r] - 1, str);
	    	count[r]--;
	    }
	    
	    return ret;
	}
	
	public static void main(String[] args) {
		List<Integer> test = new ArrayList<>();
		test.add(3);
		test.add(30);
		test.add(34);
		test.add(5);
		test.add(9);
		
		System.out.println(largestNumber(test));
		
	}
}
