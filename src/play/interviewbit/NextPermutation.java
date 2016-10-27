package play.interviewbit;

import java.util.ArrayList;

public class NextPermutation {
	/**
	 * 
	 * @param a
	 * {@link} https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
	 */
	public void nextPermutation(ArrayList<Integer> a) {
	    int n = a.size();
	   // int[] num = new int[n];
	   // a.toArray(num);
	    if(n <= 1)
	        return;
	        
	    int k = -1;
	    int l = 0;
	    
	    for (int i =0; i<n-1; i++) {	// find point of Decrease in array
	        if (a.get(i) < a.get(i+1))
	            k = i;
	    }

	    if(k == -1){
	        // do nothing
	    } else { // swap higher value highest index
    	    for (int j = 0; j < n; j++){
    	        if(a.get(k) < a.get(j))
    	            l = j;
    	    }
    	    
	        int temp = a.get(k);
	        a.set(k, a.get(l));
	        a.set(l, temp);
	    }

        for(int i = n-1; i > k; i--, k++) { // reverse all values after point of decrease
            int temp = a.get(i);
            a.set(i, a.get(k+1));
            a.set(k+1, temp);
        }
	}
}
