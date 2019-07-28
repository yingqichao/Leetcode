package dp;
import java.util.*;
public class packageDP {

    public static void main(String[] args) {
        //round robin

        int[] time = new int[]{1,2,1,1,1,4};
        int[][] pr = new int[][]{new int[]{1,2},new int[]{1,3},new int[]{1,4},new int[]{2,5},new int[]{3,5},new int[]{4,5},new int[]{4,6}};

        List<Integer> list = minTime(time,pr);
        for(int i:list)
            System.out.println(i);

//        System.out.println(minTime);
    }

    public static List<Integer> list = new LinkedList<>();
    public static int minTime = Integer.MAX_VALUE;

    public static List<Integer> minTime(int[] time, int[][] pr) {
        int num = time.length+1;
        //输出顺序
        int[] res = new int[num+1];

        int len = pr.length;

        //输入的度函数
        int[] inDegree = new int[num];


        for(int i = 0; i < len; i++) {
            inDegree[pr[i][1]]++;
        }

        Queue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);

        //寻找入度为0的任务
        for(int i = 1; i < num; i++) {
            if (inDegree[i] == 0) {
                q.offer(new int[]{i,time[i]});
            }
        }

//        min(q,time,inDegree,new LinkedList<>(),pr,0);
        //这里本来是dfs了，事实证明应该直接Greedy
        while(q.size()!=0){
            int[] in = q.poll();int item = in[0];int addTime = in[1];list.add(item);
            for(int i = 0; i < pr.length; i++) {
                if(pr[i][0] == item) {
                    inDegree[pr[i][1]]--;
                    if (inDegree[pr[i][1]] == 0) {
                        q.offer(new int[]{pr[i][1],time[pr[i][1]-1]});
                    }
                }
            }
        }

        return list;
    }

    public static void min(Set<Integer> q,int[] time,int[] inDegree,List<Integer> had,int[][] pr,int totalTime){
//        System.out.println(had.size());
        if(had.size()==time.length && totalTime<minTime){
            list = new LinkedList<>(had);
            minTime = totalTime;
        }

        for(int item:q){
            List<Integer> newList = new LinkedList<>();

            Set<Integer> set = new HashSet<>();
            had.add(item);
            for(int i = 0; i < pr.length; i++) {
                if(pr[i][0] == item) {
                    inDegree[pr[i][1]]--;
                    newList.add(pr[i][1]);
                    if (inDegree[pr[i][1]] == 0) {
                        set.add(pr[i][1]);
                    }
                }
            }
            set.addAll(q);set.remove(item);
            min(set,time,inDegree,had,pr,totalTime*2+time[item-1]);
            for(int in:newList)    inDegree[in]++;

            had.remove(had.size()-1);
        }
    }

}
