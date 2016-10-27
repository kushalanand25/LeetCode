package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAXGAP {
	// DO NOT MODIFY THE LIST
	public static int maximumGap(final List<Integer> a) {
		int n = a.size();
		int diff = 0;
		if (n <= 1)
			return diff;

		// int curr;
		// Integer[] arr = new Integer[n];
		// a.toArray(arr);

		// Arrays.sort(arr);

		// for(int i=1; i<n; i++){
		// curr = arr[i] - arr[i-1];
		// diff = Math.max(diff, curr);
		// }
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int ai;
		for (int i = 0; i < n; i++) {
			ai = a.get(i);
			// ai1 = a.get(i-1);

			min = Math.min(min, ai);
			max = Math.max(max, ai);
		}

		int gap = ((max - min-1) / (n - 1)) + 1;
		int[] minb = new int[n - 1];
		int[] maxb = new int[n - 1];

		Arrays.fill(minb, Integer.MAX_VALUE);
		Arrays.fill(maxb, Integer.MIN_VALUE);

		int idx;
		for (int i = 0; i < n; i++) {
			ai = a.get(i);
			idx = (ai - min) / gap;

			if (ai == max || ai == min)
				continue;

			minb[idx] = Math.min(minb[idx], ai);
			maxb[idx] = Math.max(maxb[idx], ai);
		}

		int maxVal = max;

		for (int i = 0; i < n - 1; i++) {
			max = minb[i];

			if (max != Integer.MAX_VALUE)
				diff = Math.max(diff, max - min);

			if (maxb[i] != Integer.MIN_VALUE)
				min = maxb[i];
		}

		diff = Math.max(diff, maxVal - min);

		return diff;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(10);
		al.add(5);
		System.out.println(maximumGap(al));
	}
}
