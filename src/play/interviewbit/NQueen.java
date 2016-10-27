package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueen {
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> sol	= new ArrayList<>();
		
		if (n == 1) {
			ArrayList<String> al	= new ArrayList<>();
			al.add("Q");
			sol.add(al);
			return sol;
		}
		
		int[] board	 = new int[n];
		Arrays.fill(board, -1);
		
		nqueen(board, 0 ,n ,sol);
		
		return sol;
	}
	
	private void nqueen(int[] board, int curr, int n, ArrayList<ArrayList<String>> sol) {
		if( curr == n) {
			sol.add(getLayout(board));
		} else {
			for (int i = 0 ; i < n; i++ ) {
				board[curr]	= i;
				if(isValid(board, curr)) {
					nqueen(board, curr+1, n, sol);
				}
			}
		}
	}
	
	private ArrayList<String> getLayout(int[] board) {
		int n = board.length;
		char[] dots	= new char[n];
		Arrays.fill(dots, '.');
		StringBuilder sb	= new StringBuilder();
		ArrayList<String> layout	= new ArrayList<>();
		
		for (int i =0 ; i < n; i++){
			sb.setLength(0);
			sb.append(dots);
			sb.setCharAt(board[i], 'Q');
			layout.add(sb.toString());
		} 
		
		return layout;
	}

	private boolean isValid(int[] b, int p) {
		for (int i = 0 ; i<p; i++) {
			if(b[i] == b[p] || Math.abs(b[i] - b[p]) == (p-i)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		NQueen inst	= new NQueen();
		System.out.println(inst.solveNQueens(1));
		System.out.println(inst.solveNQueens(4));
		System.out.println(inst.solveNQueens(8));
	}
}
