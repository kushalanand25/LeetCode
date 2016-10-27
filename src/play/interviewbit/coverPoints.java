package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class coverPoints {
	public static void main(String[] args) {
		
		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();
		String arx = "4 8 -7 -5 -13 9 -7 8";
		String ary = "4 -15 -10 -3 -13 12 8 -8";
		
		X = (ArrayList<Integer>) Arrays.stream(arx.split("[\\s]")).map(Integer::valueOf).collect(Collectors.toList());
		Y = (ArrayList<Integer>) Arrays.stream(ary.split("[\\s]")).map(Integer::valueOf).collect(Collectors.toList());
		
		System.out.println(coverPoints(X, Y));
	}
	
	static public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int que = X.size();
        int steps = 0;
        int distX ;
        int distY ;
        
        for(int i = 1 ; i < que; i++){
            distX = (int)Math.abs(X.get(i) - X.get(i-1));
            distY = (int)Math.abs(Y.get(i) - Y.get(i-1));
            steps += distX+distY - Math.min(distX,distY);
            System.out.println(distX +","+distY+" = "+steps);
        }
        
         return steps;
    }
}
