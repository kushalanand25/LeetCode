package play.interviewbit;

public class BinaryDivide {
	public static int divide_my(int dividend, int divisor) {
	    int quo = 0;
	    boolean minus = (dividend < 0) ^ (divisor < 0);
	    int numerator = Math.abs(dividend);
	    int denominator = Math.abs(divisor);
	    int mask = 1;
	    
	    if(denominator == 1) {
	    	return minus ? -numerator : (numerator != 0 && numerator == -numerator) ? Integer.MAX_VALUE : numerator;
	    }
	    
//	    if(numerator == -numerator || denominator == -denominator){
//	    	return Integer.MAX_VALUE;
//	    }
	    
	    while ( 0 < mask && mask < Integer.MAX_VALUE && denominator < numerator) {
	        denominator <<= 1;
	        mask <<= 1;
	    }
	    
	    while(mask >= 1){
	        if(denominator <= numerator) {
	            quo += mask;
	            numerator -= denominator;
	        }
	        
	        denominator >>=1;
	        mask >>=1;
	    }
	    
	    return minus ? -quo : quo;
	}
	
	public static void main(String[] args) {
//		System.out.println(divide(5, 2));
//		System.out.println(divide(2147483647 , 1));
//		System.out.println(divide(100, -10));
//		System.out.println(divide(-2147483648, -1));
//		System.out.println(divide(-2147483648, 1));
//		System.out.println(divide(0, 1));
//		System.out.println(divide(-2147483648, -2147483648));
		System.out.println(divide(-2147483648, -10000000));
	}

	private static int divide(int dividend, int divisor) {
		//try to know if the result is positive or negative
	    Boolean positive=true;
	    if(dividend>=0&&divisor>0||dividend<=0&&divisor<0){
	        positive=true;
	    }else if(dividend<=0&&divisor>0||dividend>=0&&divisor<0){
	        positive=false;
	    }else{
	        return Integer.MAX_VALUE;
	    }

	    //First turn it to long to make the operations easier
	    long ldividend=Math.abs((long)dividend);
	    long ldivisor=Math.abs((long)divisor);
	    long result=0;
	    while(ldividend>=ldivisor){
	        long tmpDivisor=ldivisor;
	        long tmpResult=1;
	        //use bit manipulation to get the biggest result once a time
	        while((tmpDivisor<<1)<ldividend){tmpDivisor<<=1;tmpResult<<=1;}
	        ldividend-=tmpDivisor;
	        result+=tmpResult;
	    }
	    //what should do when result is larger than the MAX
	    if(result>Integer.MAX_VALUE&&positive)
	        return Integer.MAX_VALUE;
	    if(result>Integer.MAX_VALUE&&!positive)
	        return Integer.MIN_VALUE;
	    if(positive){
	        return (int)result;
	    }else{
	        return -1*(int)result;
	    }
	}
}
