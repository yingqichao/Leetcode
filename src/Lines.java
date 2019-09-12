/**
 * @author Qichao Ying
 * @date 2019/9/10 17:08
 * @Description DEFAULT
 */
import java.util.*;
public class Lines {
    public static int max = 0;

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5},new int[]{1,9,2,5,1}));
    }
    public static int maxUncrossedLines(int[] A, int[] B) {
        Map<Integer,List<Integer>> b = new HashMap<>();
        for(int i=0;i<B.length;i++){
            List<Integer> list = b.getOrDefault(B[i],new LinkedList<>());
            list.add(i);b.put(B[i],list);
        }

        back(A,b,0,0,-1);

        return max;
    }

    public static void back(int[] A,Map<Integer,List<Integer>> b,int index,int connected,int restrict){
        if(restrict==b.size() || index>=A.length){
            max = Math.max(max,connected);
            return;
        }

        if(connected+A.length-index<=max)   return;

        //connect if possible
        if(b.containsKey(A[index])){
            List<Integer> list = b.get(A[index]);
            for(int in:list){
                if(in>restrict)
                    back(A,b,index+1,connected+1,in);
            }

        }

        //do not connect
        back(A,b,index+1,connected,restrict);


    }
}
