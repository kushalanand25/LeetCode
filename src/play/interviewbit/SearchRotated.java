package play.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SearchRotated {
	// DO NOT MODIFY THE LIST
	public static int search(final List<Integer> a, int b) {
	    int n = a.size();
	    if (n == 1){
	        return a.get(0) == b ? 0 : -1;
	    }
	    
	    int pivot = getPivot(a); 
	    IO.SOP(pivot);
	    int beg = 0;
	    int end = n-1;
	    int idx = -1;
	    int mid, midActual;
	    
	    while(beg <= end) {
	        mid = (beg+end)/2;
	        midActual = mod(mid+pivot,n);
	        
	        if(a.get(midActual) == b) {
	            idx = midActual;
	            break;
	        } else if (a.get(midActual) < b) { 
	            beg = mid + 1;
	        } else {
	            end = mid - 1;
	        }
	    }
	    
	    return idx;
	}
	
	private static int mod(int x, int n) {
	    return (x+n)%n;
	}
	
	private static int getPivot(List<Integer> a) {
	    int n = a.size();
	    int beg = 0;
	    int end = n-1;
	    int mid;
	    int prev, next;
	    
	    if(n == 1)
	        return 0;
	    
	    while(beg < end){
    	    if(a.get(beg) < a.get(end)){
    	        return beg;
    	    } 
    	    
    	    mid = (beg+end)/2;
    	    prev = (mid+n-1)%n;
    	    next = (mid+1)%n;
    	    if(a.get(mid) < a.get(prev) && a.get(mid) < a.get(next)){
    	        return mid;
    	    } else if(a.get(mid) <= a.get(end)) {
    	        end = mid; 
    	    } else if(a.get(mid) >= a.get(beg)) {
    	        beg = mid+1; 
    	    }
	    }  

        return -1;	
	}
	
	public static void main(String[] args) {
		int N = IO.INT();
		int[] arr = IO.IAR(N);
		int b = IO.INT();
		List<Integer> lst = new ArrayList<>(N);
		
		for (int a : arr){
			lst.add(a);
		}
		
		IO.SOP(search(lst,b));
		IO.PRINT();
	}
}
