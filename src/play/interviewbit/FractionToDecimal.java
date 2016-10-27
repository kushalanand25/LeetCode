package play.interviewbit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FractionToDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
	    /*double div  = (double)numerator/denominator;
	    String str  = String.valueOf(div);
	    int fp      = str.indexOf(".");
	    StringBuilder sb    = new StringBuilder(str.substring(0,fp));
	    char[] decimal  	= str.substring(fp+1, str.length()).toCharArray();
	    
	    System.out.println(Arrays.toString(decimal));
	    if(decimal.length == 1){
	    	char ch = decimal[0];
	    	if(ch != '0'){
	    		sb.append('.');
	    		sb.append(decimal[0]);
	    	}
	    } else {
	    	sb.append('.');
	    }
	    
	    return sb.toString();*/
		boolean minus = (numerator < 0) ^ (denominator < 0);
		
		long num = numerator < 0 ? (long)numerator * -1 : numerator;
		long deno = denominator < 0 ? (long)denominator * -1 : denominator;
			
		long q = num / deno;
	    long rem = num % deno;
	    
	    StringBuilder sb    = new StringBuilder();
	    
	    if(minus && rem != 0) {
	    	sb.append('-');
	    }
	    sb.append(String.valueOf(q));
	    
	    
	    /*if(rem != 0){
	    	StringBuilder sb2    = new StringBuilder();
	    	Set<Long> set = new HashSet<>();
	    	boolean flag = false;
	    	sb.append('.');
	    	
		    do {
		    	rem *= 10;
		    	long q2 = rem / deno;
		    	rem = rem %  deno;
		    	
		    	if(!set.add(rem)){
		    		flag = true;
		    		break;
		    	}
		    	sb2.append(String.valueOf(q2));
		    } while (rem != 0);
		    
		    if(flag){
		    	sb.append('(');
		    	sb.append(sb2);
		    	sb.append(')');
		    } else {
		    	sb.append(sb2);
		    }
	    }*/
	    
	    if(rem != 0){
	    	Map<Long,Integer> map=new HashMap<>();
	    	
	    	sb.append('.');
	    	rem *= 10; 
	    	
	    	while(!map.containsKey(rem)){
	    		map.put(rem, sb.length());
	    		sb.append(String.valueOf(rem/deno));
	    		rem = (rem % deno) * 10;
	    		if(rem == 0)
	    			return sb.toString();
	    	}
	    	return sb.insert(map.get(rem),"(").append(")").toString();
	    }
	    
	    
	    return sb.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(fractionToDecimal(2,1));
//		System.out.println(fractionToDecimal(1,2));
//		System.out.println(fractionToDecimal(2,3));
		System.out.println(fractionToDecimal(-2147483648,-1));
		System.out.println(fractionToDecimal(-1,2));
		System.out.println(fractionToDecimal(0,-1));
		System.out.println(fractionToDecimal(87,22));
	}
}
