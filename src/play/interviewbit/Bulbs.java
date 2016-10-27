package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Bulbs {
	public static int bulbs(ArrayList<Integer> a) {
        int n = a.size();
        BitSet bs = new BitSet();
        int idx =0;
        for (Integer x : a) {
            if (x == 1)
                bs.set(idx);
            idx++;
        }
        
        int count = 0;
        
        for (int i = 0; bs.cardinality() < n && i < n; i++) {
            int st  = bs.nextClearBit(0);
            bs.set(st);
            bs.flip(st+1,n);
            count++;
        }
        
        return count;
    }
	
	public static int bulbs2(ArrayList<Integer> a) {
        if(a == null || a.size() == 0) return 0;
        int count = 0;
        int state = 0;
         
        for(int i = 0; i<a.size(); i++){
            if(a.get(i) == state){
                count++;
                state = 1-state;
            }
        }
       return count;
    }
	
	public static void main(String[] args) {
		Integer[] ip1	= {0,1,0,1};
		System.out.println(bulbs(new ArrayList<>(Arrays.asList(ip1))));
		System.out.println(bulbs2(new ArrayList<>(Arrays.asList(ip1))));
	}
}
