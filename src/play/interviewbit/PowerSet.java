package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;

public class PowerSet {
	static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		ret = new ArrayList<>();
		int n = a.size();
		if(n <= 0) {
			ret.add(new ArrayList<>());
			return ret;
		}
		BitSet mask = new BitSet(n);
		Collections.sort(a);
		
	    powerSet(a,mask,0);
	    
	    Collections.sort(ret,new ArrayCompare());
	    return ret;
	}
	
	private static class ArrayCompare implements Comparator<ArrayList<Integer>> {

		@Override
		public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
			int l1 = o1.size();
			int l2 = o2.size();
			int l = Math.min(l1, l2);
			
			for(int i = 0; i <l ; i++){
				int c1 = o1.get(i);
				int c2 = o2.get(i);
				if(c1 != c2)
					return c1 - c2;
			}
			
			return l1 - l2;
		}
	} 
	
	private static void powerSet(ArrayList<Integer> a, BitSet mask, int k) {
		if( k == a.size() -1){
			mask.clear(k);
			appendList(a,mask);
			mask.set(k);
			appendList(a,mask);
			return;
		}
		
		mask.clear(k);
		powerSet(a,mask,k+1);
		
		mask.set(k);
		powerSet(a,mask,k+1);
		
	}

	private static void appendList(ArrayList<Integer> a, BitSet mask) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i = 0; i < a.size(); i++) {
			if(mask.get(i)) {
				row.add(a.get(i));
			}
		}
		ret.add(row);
	}

	public static void main(String[] args) {
		ArrayList<Integer> ip0	= new ArrayList<Integer>();
		ArrayList<Integer> ip1	= new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3}));
		System.out.println(subsets(ip0));
		System.out.println(subsets(ip1));
	}
}
