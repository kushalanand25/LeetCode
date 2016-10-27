package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
	static Map<Integer,ArrayList<String>> pad;
    static {
        pad = new HashMap<>();
        pad.put(0, new ArrayList<String>(Arrays.asList(new String[]{"0"})));
        pad.put(1, new ArrayList<String>(Arrays.asList(new String[]{"1"})));
        pad.put(2, new ArrayList<String>(Arrays.asList(new String[]{"a","b","c"})));
        pad.put(3, new ArrayList<String>(Arrays.asList(new String[]{"d","e","f"})));
        pad.put(4, new ArrayList<String>(Arrays.asList(new String[]{"g","h","i"})));
        pad.put(5, new ArrayList<String>(Arrays.asList(new String[]{"j","k","l"})));
        pad.put(6, new ArrayList<String>(Arrays.asList(new String[]{"m","n","o"})));
        pad.put(7, new ArrayList<String>(Arrays.asList(new String[]{"p","q","r","s"})));
        pad.put(8, new ArrayList<String>(Arrays.asList(new String[]{"t","u","v"})));
        pad.put(9, new ArrayList<String>(Arrays.asList(new String[]{"w","x","y","z"})));
    }
    
	public static ArrayList<String> letterCombinations(String a) {
		int n = a.length();
	    if(n < 1)
	       return new ArrayList<String>();
	    if( n == 1)
	        return pad.get(Integer.parseInt(a));
	    else {
	        ArrayList<String> prefix = pad.get(Integer.parseInt(a.substring(0,1)));
	        ArrayList<String> suffix = letterCombinations(a.substring(1,n));
	        
	        ArrayList<String> comb = new ArrayList<String>();
	        for(String p : prefix){
	            for(String s : suffix){
	                comb.add(p+s);
	            }
	        }
	        return comb;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(letterCombinations("7"));
		System.out.println(letterCombinations("23"));
	}
}
