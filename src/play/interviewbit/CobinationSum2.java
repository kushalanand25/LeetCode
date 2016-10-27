package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CobinationSum2 {
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		int n = a.size();
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    
	    if(n == 0 ) {
	        ret.add(a);
	        return ret;
	    }
	    Collections.sort(a);
	    ArrayList<Integer> lst   = new ArrayList<>();
	    cSum(a, 0, b, lst, ret);
	    
	    Set<ArrayList<Integer>> set = new HashSet<>(ret);
	    
	    ret.clear();
	    ret.addAll(set);
	    
	    return ret;
	}
	
	private static void cSum (ArrayList<Integer> a, int start, int target,ArrayList<Integer> lst,
	        ArrayList<ArrayList<Integer>> ret) {
	   
        if (target == 0) {
            ret.add(new ArrayList<>(lst));
            return;
        }
        
	    for( int i = start; i < a.size(); i++) {
	    	int ai	= a.get(i);
	    	if (target < ai)
	    		continue;
	    	
	    	lst.add(ai);
            cSum(a, i+1, target - ai , lst, ret);
	        lst.remove(lst.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		Integer[] ip1	= {10,1,2,7,6,1,5};
		int target1		= 8;
		Integer[] ip2	= {8, 10, 6, 11, 1, 16, 8};
		int target2		= 28;
		
		System.out.println(combinationSum(new ArrayList<Integer>(Arrays.asList(ip1)), target1));
		System.out.println(combinationSum(new ArrayList<Integer>(Arrays.asList(ip2)), target2));
	}
}
