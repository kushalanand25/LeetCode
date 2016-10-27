package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
	    int n = a.size();
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	    
	    if(n == 0 ) {
	        ret.add(a);
	        return ret;
	    }
	    a   =  new ArrayList<Integer>(new HashSet<Integer>(a));
	    Collections.sort(a);
	    ArrayList<Integer> lst   = new ArrayList<>();
	    cSum(a, 0, b, lst, ret);
	    
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
            cSum(a, i, target - ai , lst, ret);
	        lst.remove(lst.size() - 1);
	    }
	}
	
	public static void main(String[] args) {
		Integer[] ip1	= {2,3,6,7};
		int target1		= 7;
		
		System.out.println(combinationSum(new ArrayList<Integer>(Arrays.asList(ip1)), target1));
	}
}
