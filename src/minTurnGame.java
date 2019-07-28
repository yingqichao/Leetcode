import java.util.*;
public class minTurnGame {


    public static int[][] memo;

    public static void main(String[] args) {
        System.out.println(findRotateSteps("godding",
                "gd"));
    }

    public static int findRotateSteps(String ring, String key) {
        memo = new int[ring.length()][key.length()];
        Map<Character,List<Integer>> map = new HashMap<>();
        for(int i=0;i<ring.length();i++){
            List<Integer>   list = map.getOrDefault(ring.charAt(i),new LinkedList<>());
            list.add(i);
            map.put(ring.charAt(i),list);
        }

        return helper(ring,key,0,0,map);

    }

    public static int helper(String realring,String realkey,int ring,int key,Map<Character,List<Integer>> map){
        if(memo[ring][key]!=0)
            return memo[ring][key];
        int turn = minTurn(map,ring,realkey.charAt(key),realring);
        if(key==realkey.length()-1){
            memo[ring][key] = turn;
            return turn;
        }

        int min = Integer.MAX_VALUE;
        List<Integer> list = map.get(realkey.charAt(key));
        for(int in:list){
            min = Math.min(min,Math.min(Math.abs(ring-in),realring.length()-Math.abs(ring-in))+helper(realring,realkey,in,key+1,map));

        }
        min++;

        memo[ring][key] = min;
        return min;


    }

    public static int minTurn(Map<Character,List<Integer>> map,int pos,char c,String str){
        List<Integer> list = map.get(c);int min = Integer.MAX_VALUE;
        for(int loc:list){
            min = Math.min(min,Math.abs(loc-pos));
            min = Math.min(min,str.length()-Math.abs(loc-pos));
        }

        return min+1;

    }
}
