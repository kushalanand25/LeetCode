package play.interviewbit;

import java.util.Arrays;

public class ClimbStairs {
	static public int climbStairs(int a) {
	    if (a <= 2)
	        return a;
	    int[] s = new int[a+1];
	    s[0]    = 1;
	    s[1]    = 1;
	    
	    for (int i =2 ; i <= a; i++){
	        s[i]    = s[i-1] + s[i-2];
	    }
	    
	    System.out.println(Arrays.toString(s));
	    return s[a];
	}
	
	public static void main(String[] args) {
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(5));
		System.out.println(climbStairs(6));
	}
}
