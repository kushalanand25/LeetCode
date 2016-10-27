package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix {
	private static class TrieNode {
        int count;
        TrieNode[] child = new TrieNode[26];
        
        public TrieNode (int count) {
            this.count = count;
        }
    }
    
	public ArrayList<String> prefix(ArrayList<String> a) {
	    TrieNode root           = new TrieNode(0);
	    for (String str : a){
	        insert(root,str);
	    }
	    ArrayList<String> sol   = new ArrayList<String>(a.size());
	    
	    for (String str : a){
	        sol.add(getUniquePrefix(root,str));
	    }
	    
	    return sol;
	}
	
	private void insert(TrieNode root, String str) {
	    TrieNode tmp   = root;
	    for (char ch : str.toCharArray()) {
	        if (tmp.child[ch - 'a'] == null) {
	            tmp.child[ch - 'a'] = new TrieNode(1);
	        } else {
	            tmp.child[ch - 'a'].count++;
	        }
	        tmp = tmp.child[ch - 'a'];
	    }
	}
	
	private String getUniquePrefix(TrieNode root, String str){
	    TrieNode tmp   = root;
	    int idx =0;
	    
	    for (char ch : str.toCharArray()) {
	        idx++;
	        if (tmp.child[ch - 'a'] == null)
	            return "";
	        else if (tmp.child[ch - 'a'].count == 1){
	            return str.substring(0,idx);
	        } else {
	            tmp = tmp.child[ch - 'a'];
	        }
	    }
	    
	    return "";
	}
	
	public static void main(String[] args) {
		String[] ip1	= {"zebra", "dog", "duck", "dove"};
		ShortestUniquePrefix inst	= new ShortestUniquePrefix();
		System.out.println(inst.prefix(new ArrayList<>(Arrays.asList(ip1))));
	}
}
