package play.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		
		List<List<String>> list1 = new ArrayList<>();
		List<String> subList = new ArrayList<String>();
		subList.add("1");
		list1.add(subList);
		
		System.out.println(spiral(list1));
		
		list1 = new ArrayList<>();
		subList = new ArrayList<String>();
		subList.add("1");
		subList.add("2");
		subList.add("3");
		list1.add(subList);
		
		subList = new ArrayList<String>();
		subList.add("4");
		subList.add("5");
		subList.add("6");
		list1.add(subList);
		
		subList = new ArrayList<String>();
		subList.add("7");
		subList.add("8");
		subList.add("9");
		list1.add(subList);
		
		System.out.println(spiral(list1));
		
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		ArrayList<Integer> sublist2 = new ArrayList<>();
		sublist2.add(1);
		sublist2.add(2);
		sublist2.add(3);
		list2.add(sublist2 );
		
		sublist2 = new ArrayList<>();
		sublist2.add(4);
		sublist2.add(5);
		sublist2.add(6);
		list2.add(sublist2 );
		
		
		System.out.println(performOps(list2 ));
	}
	
	private static List<String> spiral(List<List<String>> a){
		List<String> result = new ArrayList<>();
		int m,n;
		m = a.size();
		n = a.get(0).size();
		
		int t,b,l,r;
		t=0;
		b=m-1;
		l=0;
		r=n-1;
		int dir = 0;
		
		while (l<=r && t<=b ) {
			switch(dir){
				case 0 :{
					for (int i = l; i <= r; i++ )
						result.add(a.get(t).get(i));
					t++;
					dir++;
					break;
				}
				case 1 :{
					for (int i = t; i <= b; i++ )
						result.add(a.get(i).get(r));
					r--;
					dir++;
					break;
				}
				case 2 :{
					for (int i = r; i >= l; i-- )
						result.add(a.get(b).get(i));
					b--;
					dir++;
					break;
				}
				case 3 :{
					for (int i = b; i >= t; i-- )
						result.add(a.get(i).get(l));
					l++;
					dir = 0;
					break;
				}
			}
		}
		
		
		return result;
	}
	

	static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
	        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
	        for (int i = 0; i < A.size(); i++) {
	            B.add(new ArrayList<Integer>());
	        
	            for (int j = 0; j < A.get(i).size(); j++) {
	                B.get(i).add(0);
	            }
	
	            for (int j = 0; j < A.get(i).size(); j++) {
	                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
	            }
	        }
	        return B;
	}


}
