package play.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class IPGenerator {
	public static ArrayList<String> restoreIpAddresses0(String s) {
		ArrayList<String> al = new ArrayList<>();
		int len = s.length();
		if (len < 4)
			return al;
		char dot = '.';
		int l = len - 3;
		StringBuilder sb = new StringBuilder();
		
		for(int a=0; a<l; a++){
			for(int b=0; b < l-a; b++){
				for(int c=0; c < l-a-b; c++){
					sb.setLength(0);
					sb.append(s);
					sb.insert(a+1, dot);
					sb.insert(a+b+3, dot);
					sb.insert(a+b+c+5, dot);
					
					al.add(sb.toString());
				}
			}
		}
		
		Collections.sort(al);
		
		return al;
	}
	
	public static ArrayList<String> restoreIpAddresses(String s) {
	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    ArrayList<String> t = new ArrayList<String>();
	    dfs(result, s, 0, t);
	 
	    ArrayList<String> finalResult = new ArrayList<String>();
	 
	    for(ArrayList<String> l: result){
	        StringBuilder sb = new StringBuilder();
	        for(String str: l){
	            sb.append(str+".");
	        }
	        sb.setLength(sb.length() - 1);
	        finalResult.add(sb.toString());
	    }
	 
	    return finalResult;
	}
	 
	public static void dfs(ArrayList<ArrayList<String>> result, String s, int start, ArrayList<String> t){
	    //if already get 4 numbers, but s is not consumed, return
	    if(t.size()>=4 && start!=s.length()) 
	        return;
	 
	    //make sure t's size + remaining string's length >=4
	    if((t.size()+s.length()-start+1)<4) 
	        return;
	 
	    //t's size is 4 and no remaining part that is not consumed.
	    if(t.size()==4 && start==s.length()){
	        ArrayList<String> temp = new ArrayList<String>(t);
	        result.add(temp);
	        return;
	    }
	 
	    for(int i=1; i<=3; i++){
	        //make sure the index is within the boundary
	        if(start+i>s.length()) 
	            break;
	 
	        String sub = s.substring(start, start+i);
	        //handle case like 001. i.e., if length > 1 and first char is 0, ignore the case.
	        if(i>1 && s.charAt(start)=='0'){
	            break;    
	        }
	 
	        //make sure each number <= 255
	        if(Integer.parseInt(sub)>255)
	            break;
	 
	        t.add(sub);
	        dfs(result, s, start+i, t);
	        t.remove(t.size()-1);
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));	// [“255.255.11.135”, “255.255.111.35”]
//		System.out.println(restoreIpAddresses("121212121"));	// ["1.21.212.121"],["1.212.12.121"],["1.212.121.21"],["12.1.212.121"],["12.12.12.121"],["12.12.121.21"],["12.121.2.121"],["12.121.21.21"],["12.121.212.1"],["121.2.12.121"],["121.2.121.21"],["121.21.2.121"],["121.21.21.21"],["121.21.212.1"],["121.212.1.21"],["121.212.12.1"]
	}
	
}
