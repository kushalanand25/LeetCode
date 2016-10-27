package play.interviewbit;

import static play.interviewbit.IO.IAR;
import static play.interviewbit.IO.INT;
import static play.interviewbit.IO.PRINT;
import static play.interviewbit.IO.SOP;
import static play.interviewbit.IO.toList;

import java.util.ArrayList;


public class CONTAINER {
	public static int maxArea(ArrayList<Integer> a) {
	    int n = a.size();
	    int max = 0;
	    int vol, ai, aj;
	    
	    int amax = -1, m = 0;
	    for(int i=0; i<n; i++) {
	    	ai = a.get(i);
	    	if(amax < ai ) {
	    		m = i;
	    		amax = ai;
	    	}
	    }
	    
	    n = a.size();
	    int p = 0; 
	    int q = n-1;
	    int al,ar;
	    al = ar = -1;
	    
	    while(p<=m && q >= m) {
	    	ai = a.get(p);
	    	aj = a.get(q);
	    	
	    	if (al < ai) {
	    		al = ai;
	    	}
	    	
	    	if (ar < aj) {
	    		ar = aj;
	    	}
	    	
	    	vol = (q-p) * Math.min(al, ar);
	    	max = Math.max(max, vol);
	    	if (al < ar ) {
	    		p++;
	    	} else {
	    		q--;
	    	}
	    }
	    
//	    for(int i =0; i<n-1; i++) {
//	    	ai = a.get(i);
//	        for(int j=i+1; j<n; j++){
//	        	aj = a.get(j);
//	            vol = (j-i) * (int)Math.min(ai, aj);
//	            max = Math.max(max, vol);
//	        }
//	    }
	   
	    return max;
	}
	
	public static void main(String[] args) {
		int N = INT();
		int[] arr = IAR(N);
		
		SOP(maxArea((ArrayList<Integer>) toList(arr)));
		
		PRINT();
	}
}
