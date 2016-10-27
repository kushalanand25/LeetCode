package play.interviewbit;

import java.util.ArrayList;

public class FirstMissingInteger {
	public int firstMissingPositive(ArrayList<Integer> a) {
		int n = a.size();
	    if(n <= 1)
	        return a.get(0) < 1 ? 1 : a.get(0)+1;
	    int curr, nxt;
	    
	    for(int i=0; i < n; ++i){
	        int idx = a.get(i);
	        if(idx < 1 || idx > n)
	            continue;
	        curr = idx;
	        nxt = a.get(curr-1);
	        
	        while(curr != nxt){
	            a.set(curr-1, curr);
	            curr = nxt;
	            if(curr < 1 || curr >= n)
	                continue;
	            nxt = a.get(nxt-1);
	        }
	    }
	    
	    for(int j =1; j <=n; j++){
	        if(a.get(j-1) != j)
	            return j;
	        if(j ==n &&  a.get(j-1) == j)
	            return j+1;
	    }
	    
	    return 1;
	}
	
	public static void main(String[] args) {
		
	}
}
