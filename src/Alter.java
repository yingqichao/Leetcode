import java.util.*;

/**
 * @author Qichao Ying
 * @date 2019/8/22 12:06
 * @Description DEFAULT
 */
public class Alter {
    public static void main(String[] args) {
        int[] re = rearrangeBarcodes(new int[]{1,1,1,1,2,2,3,3});
        for(int i:re)   System.out.println(i);
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();TreeMap<Integer, List<Integer>> nums = new TreeMap<>();
        for(int in:barcodes)    map.put(in,map.getOrDefault(in,0)+1);

        for(int key:map.keySet()){
            int num = map.get(key);
            List<Integer> list = nums.getOrDefault(num,new LinkedList<>());
            list.add(key);
            nums.put(num,list);
        }
        int[] res = new int[barcodes.length];Map.Entry<Integer,Integer> entry = null;
        for(int i=0;i<res.length;i++){

            int lastKey = nums.lastKey();
            List<Integer> list = nums.get(lastKey);
            int ans = list.get(0);list.remove(0);
            if(list.size()==0)  nums.remove(lastKey);
            if(entry!=null){
                List<Integer> newlist = nums.getOrDefault(entry.getValue(),new LinkedList<>());
                newlist.add(entry.getKey());
                nums.put(entry.getValue(),newlist);
                entry = null;
            }
            if(lastKey>1){
                entry = new AbstractMap.SimpleEntry<>(ans,lastKey-1);
            }


            res[i] = ans;
        }

        return res;


    }
}
