package play.interviewbit;

public class PowerMod {
	// (x^n) % d
	public static int modPow(int x, int n, int d) {
	    if(n ==0 )
	        return x==0 ? 0 : 1;
	        
	    long amd = x % d;
	    long ans = 1;
	    
	    while(n > 0){
	        if((n&1) == 1){
	            ans = (ans * amd) % d;
	        }
            n >>= 1;
            amd = (amd * amd) % d;	
	    }
	    
	    return (int)(ans < 0 ? ans + d : ans);
	}
	
	public static void main(String[] args) {
		System.out.println(modPow(-1,1,20));	// 19
		System.out.println(modPow(0,0,1));		// 0
		System.out.println(modPow(2,3,3));		// 2
		System.out.println(modPow(71045970, 41535484, 64735492));	// 20805472
//		System.out.println(BigInteger.valueOf(71045970).modPow(BigInteger.valueOf(41535484),
//				BigInteger.valueOf(64735492)));
	}
}
