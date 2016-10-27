package play.interviewbit;

import java.util.Stack;

public class SIMPLIFYPATH {
	public static String simplifyPath(String a) {
	    int n = a.length();
	    if(n <= 1)
	        return a;
	    StringBuilder sb = new StringBuilder();
	    Stack<String> stk = new Stack<>();
//	    char prev, curr;
//	    prev = '.';
	    int flag = 0;
	    StringBuilder sbr = new StringBuilder();
	    a = (a+"/").replaceAll("//", "/");
	    
	    for(char ch : a.toCharArray()){
//	        if(prev == '.'){
//	            if(ch == '.') {
//	                for(curr = stk.pop(); !stk.isEmpty() && curr != '/'; curr = stk.pop());
//	                if(stk.isEmpty())
//	                	stk.push('/');
//	            }
//	        } else if(ch == '/') {
//	        	if(prev != '/')
//	        		stk.push(ch);
//	        } else {
//	        	stk.push(ch);
//	        }
//	        prev = ch;
	    	
	    	if(ch == '/') flag++;
	    	if(flag == 1) sbr.append(ch);
	    	if(flag == 2) {
	    		String str = sbr.toString();
	    		if (str.equals("/..") && !stk.isEmpty()) {
	    			stk.pop();
	    		}
	    		if (str.indexOf("/.") == -1) {
	    			stk.push(str);
	    		}
	    		flag = 1;
	    		sbr.setLength(1);
	    	}
	    }
//	   System.out.println(stk);
	   
	   if(stk.isEmpty()){
		   sb.append("/");
	   }
	   for(;!stk.isEmpty(); sb.insert(0,stk.pop()) );
	   
	   return sb.toString(); 
	}
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));	// "/home"
		System.out.println(simplifyPath("/a/./b/../../c/"));	// "/c"
		System.out.println(simplifyPath("/home//foo/"));	// /home/foo/
		System.out.println(simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));	// /home/foo/
	}
}
