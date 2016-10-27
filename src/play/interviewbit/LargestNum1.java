package play.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNum1 {
	public static void main(String[] args) {
		List<Integer> test = new ArrayList<>();
		test.add(3);
		test.add(30);
		test.add(34);
		test.add(5);
		test.add(9);
		
		System.out.println(largestNumber(test));
		
	}

	// DO NOT MODIFY THE LIST
		public static String largestNumber(final List<Integer> a) {
		    List<Integer> radix = new ArrayList<>();
		    StringBuilder sb = new StringBuilder();
		    radix.addAll(a);
		    
		    Collections.sort(radix,new LargestNum1().new radixComparator());
		    
		    for(int x : radix){
		    	if(x > 0)
		    	sb.append(x);
		    }
		    if (sb.length() == 0)
		    	sb.append(0);
		    
			return sb.toString();
		}
		
		private class radixComparator implements Comparator<Integer>{

			@Override
			public int compare(Integer a, Integer b) {
				String strA	= Integer.toString(a);
				String strB	= Integer.toString(b);
				int la		= strA.length();
				int lb		= strB.length();
				int len 	= Math.max(la, lb);
				
				for(int i = 0; i < len; i++){
					char ch1 = strA.charAt( i < la ? i : la-1);
					char ch2 = strB.charAt( i < lb ? i : lb-1);
					
					if(ch1 == ch2){
						
					}else{
						return ch2 - ch1;
					}
				}
				
				return 0;
			}
			
		}
}
