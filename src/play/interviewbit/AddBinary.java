package play.interviewbit;

public class AddBinary {
	public static String addBinary(String a, String b) {
	    int la = a.length();
	    int lb = b.length();
	    if(la == 0)
	        return b;
	    if(lb == 0)
	        return a;
	  
	    StringBuilder sa = new StringBuilder(la>lb ? b : a);
	    StringBuilder sum =  new StringBuilder(la>lb ? a : b);
	    
	    sa = sa.reverse();
	    sum = sum.reverse();
	    boolean carry = false;
	    int i = 0;
	    char cha, chb;
	    
	    for( ; i < la && i < lb ; i++){
	        cha = sa.charAt(i);
	        chb = sum.charAt(i);
	        
	        if(cha == '0' && chb == '0'){
	            if(carry){
	                sum.setCharAt(i,'1');
	                carry = false;
	            }
	        } else if(cha == '1' && chb == '1'){
	            if(carry) {
	                sum.setCharAt(i,'1');
	            } else {
	                sum.setCharAt(i,'0');
	                carry = true;
	            }
	        } else {
	            if(carry) {
	                sum.setCharAt(i,'0');
	            } else {
	                sum.setCharAt(i,'1');
	            }
	        }
	    }
	    
	    while(carry && (i < la || i < lb)){
	        chb = sum.charAt(i);
	        if(chb == '1'){
	            sum.setCharAt(i,'0');
            } else {
                sum.setCharAt(i,'1');
                carry = false;
            }
            i++;
	    }
	    
	    if(carry){
	        sum.append('1');
	    }
	    
	    return sum.reverse().toString();
	}
	
	public static void main(String[] args) {
		String a = "1110000000010110111010100100111";
		String b = "101001";
		
		System.out.println(addBinary(a, b)); 
		System.out.println(addBinary("10001100010111000101100010100110001001101010000010011010", "101111000100100100111110010010101110101001100100101001111010011000000110")); // 101111000100100111001010101001110100001100001010110011100100011010100000 
		
	}
}
