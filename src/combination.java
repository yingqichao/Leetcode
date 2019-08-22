import java.util.*;

/**
 * @author Qichao Ying
 * @date 2019/7/26 13:47
 * @Description DEFAULT
 */
public class combination {
    public static List<List<Integer>> res = new LinkedList<>();
    public Queue<Integer> q = new PriorityQueue<>();
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));

//        List<Integer> data  = Arrays.asList(1,2,3,4);
//        List<List<Integer>> list = combinations(data,2);
//        for(List<Integer> in:list){
//            for(int i:in){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0)  return 0;
        int left = 0;int right = -1;int sum = 0;int length = Integer.MAX_VALUE;
        while(right<nums.length-1){


            right++;
            if(nums[right]>=s)  return 1;
            sum+=nums[right];


            if(sum>=s){
                // length = Math.min(length,right-left+1);
                //some elements can be removed
                while(sum-nums[left]>=s){
                    sum -= nums[left];
                    left++;
                }
                length = Math.min(length,right-left+1);
            }




        }

        return (length==Integer.MAX_VALUE)?0:length;
    }

    public static List<List<Integer>> combinations(List<Integer> data,int n){
        if(data.isEmpty() || n==0)  return new LinkedList<>();

        add(new LinkedList<>(),data,n,0);
        return res;
    }

        public static void add(List<Integer> had,List<Integer>data,int n,int index) {
            //preliminaries 前提条件  = while(tiaojian)
            if (index >= data.size()) {
                //超出啦
                return;
            }

            if (had.size() == n) {
                res.add(new LinkedList<>(had));
                return;
            }

            //early quit
            if(n==had.size()+data.size()-index){
//                had.addAll(data);
                List<Integer> temp = new LinkedList<>(had);temp.addAll(data.subList(index,data.size()));
                res.add(new LinkedList<>(temp));
                return;

            }




            //take this element on the current index
            had.add(data.get(index));
            add(had, data, n, index + 1);

            //do not take
            had.remove(had.size() - 1);
            add(had, data, n, index + 1);

        }

}
