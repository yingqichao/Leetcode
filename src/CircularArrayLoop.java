import java.util.*;
public class CircularArrayLoop {


    public static Map<Integer,Set<Integer>> map = new HashMap<>();
    public static boolean success = false;

    public static void main(String[] args) {
//        int[] days = new int[]{1,4,6,7,8,20};
//        int[] costs = new int[]{7,2,15};
//        System.out.println(mincostTickets(days,costs));

        int[] nums = new int[]{2,-1,1,2,2};

        System.out.println(circularArrayLoop(nums));

    }

    public static boolean circularArrayLoop(int[] nums) {


        for(int i=0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            addConnect(i,nums,set,-1);
            if(success)    return true;
        }
        return false;
    }

    public static Set<Integer> addConnect(int index,int[] nums,Set<Integer> visited,int directChild){
        int connect = (index+nums[index])%nums.length;
        if(connect<0)   connect += nums.length;
        if(connect==index || directChild==index)  return null;
        if(visited.contains(connect)) {
            success = true;return null;}
        visited.add(connect);

        Set<Integer> def = map.getOrDefault(index,new HashSet<>());
        def.add(connect);

        for(int in:def){
//            if(visited.contains(in)){success = true;return null;}
            Set<Integer> temp = addConnect(in,nums,visited,index);
            if(success) return null;
            if(temp!=null) visited.addAll(temp);
            if(temp!=null) def.addAll(temp);
        }

        return def;


    }

}
