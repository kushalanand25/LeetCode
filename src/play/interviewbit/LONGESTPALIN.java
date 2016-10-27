package play.interviewbit;

import java.util.Arrays;

public class LONGESTPALIN {
	public static String longestPalindrome(String a) {
	    int n = a.length();
	    int max = 1;
	    int idx = 0;
	    int curr;
	    String lp, p1, p2;
	    lp = a.substring(0, 1);
	    
//	    for(int i =0 ; i<n; i++){
//	        curr = 1;
//	        for(int j=1;i-j >= 0 && i+j < n ;j++){
//	            if(a.charAt(i-j) == a.charAt(i+j))
//	                curr+=2;
//	            else if(i-j > 0 && a.charAt(i-j-1) == a.charAt(i+j))
//	                curr++;
//	        }
//	        if (curr > max) {
//	            max = curr;
//	            idx = curr%2 ==0 ? i+1 : i;
//	        }
//	    }
//	    
//	    return a.substring(idx-(max/2), idx+(max/2)+1);
	    
	    for (int i=0; i<n-1; i++) {
	    	p1 = getPalin(a, i, i);
	    	if(p1.length() > lp.length()){
	    		lp = p1;
	    	}
	    	
	    	p2 = getPalin(a, i, i+1);
	    	if(p2.length() > lp.length()){
	    		lp = p2;
	    	}
	    }

	    return lp;
	}
	
	private static String getPalin(String s , int l, int r) {
		int n = s.length();
		int sweep = 0;
		for(; l-sweep >= 0 && r+sweep < n  && s.charAt(l-sweep) == s.charAt(r+sweep); sweep++);
		
		return sweep == 0 ? "" : s.substring(l-sweep +1,Math.min(n, r+sweep) );
	}
	
	public static void main(String[] args) {
		String[] ip = new String[]{"abb","caba","abcd", "aaaabaaa","abacdfgdcaba"};
		
		for(String str : ip) {
//			System.out.println(longestPalindrome(str));
			System.out.println(ManacherAlgo(str));
		}
	}
	
	public static String ManacherAlgo(String s) {
		if (s==null || s.length()==0)
            return "";
		
		char[] ms = addBoubndaries(s.toCharArray());	// Manacher modified String with | separated characters
		int n = ms.length;
		int[] p = new int[n];
		int c = 0;
		int r = 0;
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < n ; i++) {
			int i_mirror = 2*c-i; // equals to i' = C - (i-C)
			
//			p[i] = (r > i) ? Math.min(r-i, p[i_mirror]) : 0; 
//			
//			// expand Around Center 
//			while (ms[i+1+p[i]] == ms[i-1-p[i] ]) {
//				p[i]++;
//			}
			
			if (i > r) {
				p[i] = 0;
				x = i-1;
				y = i+1;
			} else {
				if (p[i_mirror] < (r-i) ) {
					p[i] = p[i_mirror];
					x = -1; // skip loop
				} else {
					p[i] = r-i;
					y = r+1;
					x = i*2 - y;
				}
			}
			
			while (x>=0 && y<n && ms[x] == ms[y]) {
                p[i]++;
                x--; 
                y++;
            }
			
			// If palindrome centered at i expand past R,
		    // adjust center based on expanded palindrome.
			if (i+ p[i] > r) {
				c = i;
				r = i+p[i];
			}
		}
		
		int max = -1;
		int centerIdx = 0;

		System.out.println(Arrays.toString(ms));
		System.out.println(Arrays.toString(p));
		
		for (int i=0; i < n; i++) {
			if (p[i] > max) {
				max = p[i];
				centerIdx = i;
			}
		}
		
		char[] palin = Arrays.copyOfRange(ms, centerIdx - max, centerIdx + max + 1);
		
		return String.valueOf(removeBoundaries(palin)) ;
	}

	private static char[] addBoubndaries(char[] cs) {
		if (cs==null || cs.length==0)
            return "||".toCharArray();
		
		char[] cs2 = new char[cs.length*2+1];
		for(int i = 0 ; i < cs2.length-1; i+=2 ){
			cs2[i] = '|';
			cs2[i+1] = cs[i/2];
		}
		
		return cs2;
	}
	
	private static char[] removeBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[(i*2)+1];
        }
        return cs2;
    }  
}
