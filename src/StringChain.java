/**
 * @author Qichao Ying
 * @date 2019/8/22 12:59
 * @Description DEFAULT
 */
import java.util.*;
public class StringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }

    public static int longestStrChain(String[] words) {
        Map<String,Integer> memo = new HashMap<>();
        Map<Integer,Set<String>>    map = new HashMap<>();
        for(String str:words){
            Set<String> set = map.getOrDefault(str.length(),new HashSet<>());
            set.add(str);
            map.put(str.length(),set);
        }

        for(int i=2;i<=16;i++){
            Set<String> set = map.getOrDefault(i,new HashSet<>());
            Set<String> setshort = map.getOrDefault(i-1,new HashSet<>());
            if(set.size()!=0)
                for(String strlong:set){
                    for(int k=0;k<strlong.length();k++){
                        String strshort = ((k>0)?strlong.substring(0,k):"")+
                                ((k<strlong.length()-1)?strlong.substring(k+1,strlong.length()):"");
                        if(setshort.contains(strshort)){
                            memo.put(strlong,memo.getOrDefault(strshort,1)+1);
                        }
                    }
                }
        }

        int max = 1;
        for(String in:memo.keySet())    max = Math.max(memo.get(in),max);

        return max;


    }
}
