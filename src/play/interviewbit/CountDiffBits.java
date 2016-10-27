package play.interviewbit;

import java.util.ArrayList;

/**
 * 
 * @author Kushal
 * {@link} https://www.interviewbit.com/courses/programming/topics/bit-manipulation/problems/cntbits/
 */
public class CountDiffBits {
	public static int cntBits(ArrayList<Integer> A) {
        int n = A.size();
        if(n <=1 )
            return 0;
        
        // int xor = 0;
        // int sum = 0;
        // for(int i =0 ; i < n-1; i++){
        //     for(int j = i+1; j < n; j++){
        //         xor = A.get(i).intValue() ^ A.get(j).intValue(); 
        //         // System.out.print(Integer.bitCount(xor) + " + ");
        //         sum = (int)((long)sum+(Integer.bitCount(xor) * 2)) % 1000000007;
        //     }
        //     // System.out.println();
        // }
        
        long sum = 0;
        long count = 0;
        int prd = 0;
        int mask;
        for(int i = 0 ; i<31; i++){
            count = 0;
            mask = 1<<i;
            for(int j = 0 ; j< n; j++){
                if((A.get(j) & mask ) == mask)
                    count++;
            }
            
            prd = (int)(count * (n-count) * 2) % 1000000007;
            sum = (sum + prd ) % 1000000007;
        }
        
        return (int)sum;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> A= new ArrayList<>();
		
		A.add(1);
		A.add(3);
		A.add(5);
		
		System.out.println(cntBits(A));
	}
	
}
