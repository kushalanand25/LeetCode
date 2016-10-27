package play.interviewbit;

import static play.interviewbit.IO.*;

public class COUNT_SAY {
	public static String countAndSay(int a) {
	    if(a == 1)
	        return Integer.toString(1);
	   
	    int count = 0;
	    int j;
	    StringBuilder sb = new StringBuilder("1");
	    StringBuilder sb2 = new StringBuilder();
	    char ch;
	    for(int i =1; i < a; i++){
	        count = 0;
	        sb2.setLength(0);
	        sb2.append(sb);
	        
//	        SOP(sb2);
	        ch = sb2.charAt(0);
	        sb.setLength(0);
	        
	        for(j = 0; j < sb2.length(); j++){
	            if(ch == sb2.charAt(j))
	                count++;
	            else {
	                sb.append(count).append(ch);
	                ch = sb2.charAt(j);
	                count = 1;
	            }
	        }
	        sb.append(count).append(ch);
	    }
	    
	    return sb.toString();
	}
	
	public static void main(String[] args) {
		SOP(countAndSay(5));
		PRINT();
	}
}
