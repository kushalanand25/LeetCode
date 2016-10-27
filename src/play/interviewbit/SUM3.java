package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SUM3 {
	public static int threeSumClosest(ArrayList<Integer> a, int b) {
	    Collections.sort(a);
	    int n = a.size();
	    int min = 0;
	    int x,y,z;
	    int start, end;
	    int sum;
	    
	    outer:
	    for(int i =0; i < n-2; i++){
	        x = a.get(i);
	        start = i+1;
	        end = n-1;
	        
	        while(start < end){
	            y = a.get(start);
	            z = a.get(end);
	            
	            sum = x+y+z;
	            min = (min == 0) || (Math.abs(sum - b) < Math.abs(min - b)) ? sum : min;
	            if(sum == b){
	                min = sum;
	                break outer;
	            } else if(sum > b) {
	                end--;
	            } else {
	                start++;
	            }
	        }
	    }
	    
	    return min;
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {-1,2,1,-4};
//		System.out.println( threeSumClosest(new ArrayList<Integer>(Arrays.asList(arr)),1));

		arr = new Integer[] {9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2};
		System.out.println( threeSumClosest(new ArrayList<Integer>(Arrays.asList(arr)),0));
	}
}
