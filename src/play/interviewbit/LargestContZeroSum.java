package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContZeroSum {
	public static ArrayList<Integer> lszero(ArrayList<Integer> a) {
        int n = a.size();
        // int[] prefix = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int sum = 0;
        mp.put(0, 0);
        
        for(int i =0; i < n; i++){
            sum += a.get(i);
            if( mp.containsKey(sum) ) {
                // ret = new ArrayList<Integer>(a.subList(mp.get(sum), i+1));
            } else {   
                mp.put(sum,i+1);
            }
        }
        
//         System.out.println(mp);
//         System.out.println(sum);
         
        int start = 0;
        int stop = 0;
        int max = Integer.MIN_VALUE;
        
        for(int j = n-1; j >= 0; j--){
            if(mp.containsKey(sum)) {
                if(max <= j+1 - mp.get(sum)){
                    start = mp.get(sum);
                    stop = j+1;
                    max = stop - start;
                }
            }
        	sum -= a.get(j);
        }
        ret = new ArrayList<Integer>(a.subList(start, stop));
        
        return ret;
    }
	
	public static void main(String[] args) {
		Integer[] ip1 = {1 ,2 ,-2 ,4 ,-4};
		Integer[] ip2 = {1 ,2 ,-3 ,3};
		Integer[] ip3 = {-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25};
		
		System.out.println(lszero(new ArrayList<>(Arrays.asList(ip1))));
		System.out.println(lszero(new ArrayList<>(Arrays.asList(ip2))));
		System.out.println(lszero(new ArrayList<>(Arrays.asList(ip3))));
	}
}
