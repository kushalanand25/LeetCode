package play.interviewbit;

import static play.interviewbit.IO.*;
/**
 * PAYPALISHIRING 3
 * PAHNAPLSIIGYIR
 * 
a     g     m
 b   f h   l
  c e   i k
   d     j
0123210123210
0123450123450
 * 
 * 
 * 
 * @author Kushal
 *
 */
public class ZigZag {
	public static String convert(String a, int b) {
		int n = a.length();
		if (n <= 1 || b <= 1)
			return a;

		StringBuilder sb = new StringBuilder();
		StringBuilder[] sbs = new StringBuilder[b];

		for (int s = 0; s < b; s++) {
			sbs[s] = new StringBuilder();
		}

		int j = 0;
		int tw = 2 * (b - 1);
		for (int i = 0; i < n; i++) {
			j = i % tw;
			j = (j < b) ? j : (tw - j);
//			SOPrint(j);
//			SOPrint(" ");
			sbs[j].append(a.charAt(i));
		}

		for (int s = 0; s < b; s++) {
			sb.append(sbs[s]);
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		String a = READ();
		int b = INT();
	
		SOP(convert(a,b));
		PRINT();
	}
}
