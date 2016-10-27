package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SUM3ZERO {
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
	    Collections.sort(a);
	    int n = a.size();
	    int x,y,z;
	    int start, end;
	    int sum;
	    
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    ArrayList<Integer> triplet;
	    
	    for(int i =0; i < n-2; i++){
	        
	        x = a.get(i);
	        if (i > 0 && x == a.get(i-1)) {
                continue;
            }
	        start = i+1;
	        end = n-1;
	        
	        while(start < end){
	            y = a.get(start);
	            z = a.get(end);
	            
	            sum = x+y+z;
	            if(sum == 0){
	                triplet = new ArrayList<>();
	                triplet.add(x);
	                triplet.add(y);
	                triplet.add(z);
                    
	                result.add(triplet);
	               
                    int prev = y;
	                start++;
	                end--;
	                
                    while(start < end && a.get(start) == prev)
                        start++;
	            } else if(sum > 0) {
	                end--;
	            } else {
	                start++;
	            }
	        }
	    }
	    
	    return result;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
		
		System.out.println( threeSum(new ArrayList<Integer>(Arrays.asList(arr) )) );
		// expected  [-5 0 5 ] [-5 1 4 ] [-4 -1 5 ] [-4 0 4 ] [-4 1 3 ] [-3 -2 5 ] [-3 -1 4 ] [-3 0 3 ] [-2 -1 3 ] [-2 1 1 ] [-1 0 1 ] [0 0 0 ] 
	}
}
