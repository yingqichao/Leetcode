import ListNode.ListNodeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Qichao Ying
 * @date 2019/7/26 11:00
 * @Description DEFAULT
 */
public class Combinations {
    static List<List<Integer>> list = new LinkedList<>();

    public static void main(String[] args) {
        List<Integer> data  = Arrays.asList(1,2,3,4);
        List<List<Integer>> list = combinations(data,2);
        for(List<Integer> in:list){
            for(int i:in){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinations(List<Integer> data ,int n){
        if(data.isEmpty() || n==0)  return new LinkedList<>();

        add(data,new LinkedList<>(),0,n);
        return list;
    }

    public static void add(List<Integer> data,List<Integer> had, int index, int n){
        //boundary
        if(n==0)    {
            list.add(new LinkedList<>(had));

            return;
        }
        if(index>=data.size())    return;

        //early quit
        if(data.size()-index<=n){
            List<Integer> tmp = new LinkedList<>(had);
            tmp.addAll(data.subList(index,data.size()));
            list.add(tmp);

            return;
        }


        //take this index
        had.add(data.get(index));
        add(data,had,index+1,n-1);

        //do not take this index
        had.remove(had.size()-1);
        add(data,had,index+1,n);


    }

}
