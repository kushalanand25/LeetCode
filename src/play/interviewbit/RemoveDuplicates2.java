package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates2 {
	public static int removeDuplicates(ArrayList<Integer> a) {
	    int n = a.size();
	    if( n <= 2)
	        return n;
	    
	    int n1 = 1;
	    int count = 1;
	    int x,y,idx;
	    idx = 1;
	    boolean flag = false;
	    
	    for(int i =1; i<n; i++) {
	        x = a.get(i-1);
	        y = a.get(i);
	        if(x == y){
	            count++;
	            if(count == 2){
	            	 a.set(idx, y);
	                 idx++;
	 	             n1++;
	            } else if(flag && count > 2){
//	                idx = i;
	                flag = false;
	            }
	        } else {
                a.set(idx, y);
                flag = true;
                idx++;
	            count=1;
	            n1++;
	        }
	    }
	    
	    return n1;
	}
	
	public static void main(String[] args) {
		Integer[] arr1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		Integer[] arr2 = { 1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
		ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(arr1));
		ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(arr2));
		
//		System.out.println(a1.subList(0, removeDuplicates(a1)));
		System.out.println(a2.subList(0, removeDuplicates(a2)));
	}
}
