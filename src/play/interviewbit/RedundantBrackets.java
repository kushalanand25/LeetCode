package play.interviewbit;

import java.util.Stack;

public class RedundantBrackets {
	public static int braces(String a) {
	    int bal = 0;
	    int n = a.length();
	    if(n <= 1)
	        return bal;
	    
	    Stack<Character> stk = new Stack<>();
	    boolean flag = false;
	    char p;
	    
		outer: 
		for (char ch : a.toCharArray()) {
			flag = false;
			if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				stk.push(ch);
			} else if (ch == ')') {
				inner: 
				while (!stk.isEmpty()) {
					p = stk.pop().charValue();
					if (p == '+' || p == '-' || p == '*' || p == '/') {
						flag = true;
					}
					if (p == '(')
						if (flag)
							break inner;
						else {
							bal = 1;
							break outer;
						}
				}
			}
		}
	    
	    return bal;
	}
	
	public static void main(String[] args) {
		System.out.println(braces("((a+b))"));	// 1
		System.out.println(braces("(a+(a+b))")); // 0
	}
}
