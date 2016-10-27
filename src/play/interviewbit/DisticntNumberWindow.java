package play.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DisticntNumberWindow {
	public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> sol  = new ArrayList<Integer>(A.size() - B + 1);
        Map<Integer, Integer> map   = new HashMap<>();
        Integer count = 0;
        int idx = -1;
        Integer dis = null;
        
        for (Integer key : A) {
            idx++;
            count  = map.get(key);
            count   = Integer.valueOf(count == null ? 1 : ++count);
            map.put(key,count);
            
            
            if (idx >= B) {
                dis = A.get(idx - B);
                count  = map.get(dis);
                --count;
                if (count <= 0)
                    map.remove(dis);
                else
                    map.put(dis, count);
            }
            
            if (idx >= B -1){
                sol.add(map.size());
            }
//            System.out.println(map.keySet()+ " - "+ sol);
        }
        
        return sol;
    }
	
	public static void main(String[] args) {
		Integer[] ip1	= {1, 2, 1, 3, 4, 3};
		int w1	= 3;
		int w2	= 1;
		
		DisticntNumberWindow inst	= new DisticntNumberWindow();
		System.out.println(inst.dNums(new ArrayList<>(Arrays.asList(ip1)), w1));;
		System.out.println(inst.dNums(new ArrayList<>(Arrays.asList(ip1)), w2));;
	}
}
