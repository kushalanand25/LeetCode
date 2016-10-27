package play.interviewbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicateInArray {
	/**
	 * 
	 * Split the numbers from 1 to n in sqrt(n) ranges so that range i corresponds to [sqrt(n) * i .. sqrt(n) * (i + 1)).
	 * Do one pass through the stream of numbers and figure out how many numbers fall in each of the ranges.
	 * At least one of the ranges will contain more than sqrt(n) elements.
	 * Do another pass and process just those elements in the oversubscribed range.
	 * Using a hash table to keep frequencies, you’ll find a repeated element.
	 * This is O(sqrt(n)) memory and 2 sequential passes through the stream.
	 * 
	 * @param a
	 * @return
	 */
	public int repeatedNumber(final List<Integer> a) {
		int n = a.size() - 1;
	    if( n <= 0)
	        return -1;
	   
	    int range = (int) Math.sqrt(n);
	    if (range * range < n) range++;
	    
	    Map<Integer,Integer> mpCount = new HashMap<>();
	    int key, count;
	    
	    for(int x : a){
	        key = (x-1)/range;
	        count = 1;
	        if (mpCount.containsKey(key) ) {
	            count = mpCount.get(key) + 1;
	        }
            mpCount.put(key, count);
	    }
	    
	    int sqRange = ((n-1)/range) + 1;
	    int repeatRange = -1;
	    
	    for (int i=0 ; i <= sqRange ; i++) {
	        if (mpCount.containsKey(i) && ( i < sqRange - 1 || n%range==0) ){
	            count = mpCount.get(i);
    	        if (count > range) {
    	            repeatRange = i;
    	            break;
    	        } else {
    	            repeatRange = -1;
    	        }
	        }
	    }
	    
	    if(repeatRange == -1)
	        return -1;
	        
	    int[] occur = new int[range+1];
	    for(int j=0; j <= n ; j++){
	        key = (a.get(j) - 1) / range ;
	        if(key == repeatRange) {
	            occur[(a.get(j) - 1) % range]++;
	        }
	    }
	    
	    for(int c = 0 ; c < range + 1; c++){
	        if(occur[c] > 1)
	            return repeatRange * range + c + 1;
	    }
	    
	    // This works in O(n) space
	    /*Set<Integer> set = new HashSet<>();
	    
	    for(int x : a) {
	        if(!set.add(x))
	            return x;
	    }*/
	    
	    return -1;
	}
}
