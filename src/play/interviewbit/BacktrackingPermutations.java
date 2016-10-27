package play.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class BacktrackingPermutations {
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    int n   = a.size();
	    ArrayList<ArrayList<Integer>> ret   = new ArrayList<>();
	    
	    if (n <= 1){
	        ret.add(a);
	        return ret;
	    }
	    
	    permute(a, 0, ret); 
	    return ret;   
	}
	
	private static void permute (ArrayList<Integer> a, int start,ArrayList<ArrayList<Integer>> ret){
	    if (start >= a.size()) {
	        ArrayList<Integer> inst = new ArrayList<>(a);
	        ret.add(inst);
	    } 
    
        for (int j = start; j < a.size(); j++){
            swap (a, start, j);
            permute(a, start +1 , ret);
            swap (a, start, j);
        }
	}
	
	private static void swap (ArrayList<Integer> a, int x, int y) {
	    if (x == y)
	        return;
	    Integer t   = a.get(x);
	    a.set(x, a.get(y));
	    a.set(y, t);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ip	= new ArrayList<>();
		ip.add(1);
		ip.add(2);
		ip.add(3);
		
		IO.SOP(permute(ip));
		IO.PRINT();
	}
}
