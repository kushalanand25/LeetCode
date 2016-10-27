package play.interviewbit;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Search2D {
	public static  int searchMatrix(ArrayList<ArrayList<Integer>> a, int x) {
	    int t,b,l,r;
	    int row = a.size();
	    if(row == 0)
	        return 0;
	    int col = a.get(0).size();
	    
	    if(row == 1 && col ==1)
	        return a.get(0).get(0) == x ? 1 : 0;
	    
	    int midR, midC;
	    
	    t = 0;
	    b = row -1;
	    l = 0 ;
	    r = col -1;
	    int found = 0;
	    
	    while(t<=b && l<=r){
	        midR = (t+b)/2;
	        midC = (l+r)/2;
	        
	        if(a.get(midR).get(midC) == x){
	            found = 1;
	            break;
	        } else if(a.get(midR).get(midC) < x) {
	            if(a.get(midR).get(r) >= x){
	                l = midC + 1;
	            } else {
	                t = midR + 1;
	            }
	        } else {
	            if(a.get(midR).get(l) <= x){
	                r = midC - 1;
	            } else {
	                b = midR - 1;
	            }
	        }
	    }
	    
	    return found;
	}

	private static final String INPUT = "";
	private static final String NEWLINE = System.lineSeparator();
	private static byte[] inbuf;
	private static int lenbuf, curbuf;
	private static final InputStream is;
	private static StringBuilder sb;
	private volatile static int byt;

	static {
		inbuf = new byte[1024];
		sb = new StringBuilder();
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());//new BufferedInputStream(new FileInputStream(INPUT));
	}

	public static void main(String[] args) throws Exception {
		int M,N;
		M = INT();
		N = INT();
		ArrayList<ArrayList<Integer>> a = new ArrayList<>(M);
		ArrayList<Integer> row;

		for(int i = 0; i<M ; i++){
			row = new ArrayList<>(N);
			
			for(int j =0; j<N; j++){
				row.add(INT());
			}
			a.add(row);
		}
		
		int x = INT();
		
		SOP(searchMatrix(a,x));
		PRINT();
	}

	/**
	 * ______________________________ CP shorthand methods START __________________________
	 */

	private static int getByte() throws InputMismatchException {
		if (lenbuf == -1) {
			throw new InputMismatchException("empty buffer");
		}
		if (curbuf >= lenbuf) {
			curbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException(e.getMessage());
			}
			if (lenbuf <= 0) {
				return byt = -1;
			}
		}
		return byt = inbuf[curbuf++];
	}

	private static final int INT() {
		return (int) LONG();
	}

	private static final long LONG() {
		long num = 0;
		boolean minus = false;
		while (getByte() != -1 && !((byt >= '0' && byt <= '9') || byt == '-'))
			;
		if (byt == '-') {
			minus = true;
			getByte();
		}
		for (;;) {
			if (byt >= '0' && byt <= '9') {
				num = (num * 10) + (byt - '0');
			} else {
				break;
			}
			getByte();
		}
		return (minus ? -num : num);
	}

	private static final int[] IAR(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = INT();
		}
		return a;
	}

	private static final char[][] MAZE(int m, int n) {
		char[][] maze = new char[m][];
		char[] row;
		int pos;
		for (int i = 0; i < m; i++) {
			row = new char[n];
			pos = 0;
			skip();
			while (pos < n && !isSpaceChar()) {
				row[pos++] = (char) byt;
				getByte();
			}
			maze[i] = ((n == pos) ? row : Arrays.copyOf(row, pos));
		}
		return maze;
	}

	private static boolean isSpaceChar() {
		return !(byt >= 33 && byt <= 126);
	}

	private static void skip() {
		while (getByte() != -1 && isSpaceChar())
			;
	}

	private static final String READ() {
		skip();
		StringBuilder sbRet = new StringBuilder();
		while (!(isSpaceChar())) {
			sbRet.appendCodePoint(byt);
			getByte();
		}
		return sbRet.toString();
	}

	private static final String[] SPLIT(String s) {
		return ((s == null) ? null : s.split("[\\s]"));
	}

	private static final void SOP(Object obj) {
		SOPrint(obj);
		sb.append(NEWLINE);
	}

	private static final void SOPrint(Object obj) {
		if (obj == null) {
			sb.append("null");
		} else if (obj instanceof String) {
			sb.append(obj);
		} else {
			sb.append(obj.toString());
		}
	}

	private static final void PRINT() {
		System.out.print(sb.toString());
		sb.setLength(0);
	}

	//______________________________CP shorthand END__________________________

	
}
