package play.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortMergeIntervals {
	public static class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("(").append(start).append(",").append(end).append(")");
			return builder.toString();
		}
	    
	}
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		int n = intervals.size(); 
		
		if(intervals.isEmpty() || n == 1)
			return intervals;
				
        Collections.sort(intervals, new IntervalComparator() );
        ArrayList<Interval> merge = new ArrayList<>();
        
        int st, ed;
        
        st = intervals.get(0).start;
        ed = intervals.get(0).end;
        
        for(int i=1; i<n; i++){
        	Interval inv = intervals.get(i);
        	
        	if(inv.start <= ed) {
        		ed = Math.max(ed , inv.end);
        	} else {
        		merge.add(new Interval(st, ed));
        		st = inv.start;
        		ed = inv.end;
        	}
        }
        merge.add(new Interval(st, ed));
        
		return merge;
    }
	
	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start == o2.start)
				return o1.end - o2.end;
			return o1.start - o2.start;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Interval> ip1	= new ArrayList<Interval>();
		ArrayList<Interval> ip2	= new ArrayList<Interval>();
		
		ip1.add(new Interval(1, 3));
		ip1.add(new Interval(2, 6));
		ip1.add(new Interval(8, 10));
		ip1.add(new Interval(15, 18));
		
		ip2.add(new Interval(1, 10));
		ip2.add(new Interval(2, 9));
		ip2.add(new Interval(3, 8));
		ip2.add(new Interval(4, 7));
		ip2.add(new Interval(5, 6));
		ip2.add(new Interval(6, 6));
//		ip2.add(new Interval(9, 11));
		
//		System.out.println(merge(ip1));
		System.out.println(merge(ip2));
		
		
	}
}
