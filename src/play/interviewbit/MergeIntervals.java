package play.interviewbit;

import java.util.ArrayList;

public class MergeIntervals {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> merge = new ArrayList<>();
        int x1,x2,y1,y2,min,max;
        int st,ed;
        boolean flag = false;
        boolean add = false;
        
        x2 = newInterval.start;
        y2 = newInterval.end;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        st = 0;
        ed = 0;
        
        if(x2 > y2){
            int temp = x2;
            x2 = y2;
            y2 = temp;
        }
        
        if(intervals.size() == 0){
            merge.add(new Interval(x2,y2));
            return merge;
        }
        
        for(Interval inv : intervals){
            x1 = inv.start;
            y1 = inv.end;
            
            min = Math.min(min, x1);
            max = Math.max(max, y1);
            
            if(Math.max(x1,x2) < Math.min(y1,y2)) {
                if (!flag) 
                    st = Math.min(x1,x2);
                ed = Math.max(y1,y2);
                flag = true;
                if(! (ed == y1) ){
                    continue;
                }else{
                    // System.out.println("overlap");
                }
            } else {
                if (flag) {
                    merge.add(new Interval(st,ed));
                }else if (!add && x1 > x2) {
                    merge.add(new Interval(x2,y2));
                    add = true;
                } 
                st = x1;
                ed = y1;
            }
            merge.add(new Interval(st,ed));
            
            if (flag) {
                // System.out.println("merge");
                add = true;
                flag = false;
            }
            
        }
        
        if(flag){
            merge.add(new Interval(st,ed));
        } else if(!add){
            if(min > y2 ){
                merge.add(0,new Interval(x2,y2));
            } else{
                merge.add(new Interval(x2,y2));
            }
        }
        
        return merge;
    }
	
	public class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
}
