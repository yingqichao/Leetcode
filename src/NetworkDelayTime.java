import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args)throws Exception{

        int[] person = new int[]{0,2,1,3};
        System.out.println(minSwapsCouples(person));

//        int[][] list = new int[][]{new int[]{2,1,1},new int[]{2,3,1},new int[]{3,4,1}};
//
//        System.out.println(networkDelayTime(list,4,2));

    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        int[] minTime = new int[N+1];Arrays.fill(minTime,Integer.MAX_VALUE);int newTime = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> back = new HashMap<>();
//        int currTime = 0;
        map.put(K,0);minTime[K] = 0;
        while(map.size()!=0){
            for(int key:map.keySet()){
                int hasTime = map.get(key);
                for(int[] time:times){
                    if(time[0]==key){
                        newTime = hasTime+time[2];
                        if(newTime<minTime[time[1]]){
                            minTime[time[1]] = newTime;
                            //准备添加到下一步传递的Map中
                            back.put(time[1],newTime);
                        }
                    }
                }

            }

            map = back;back = new HashMap<>();


        }
        int res = 0;
        for(int i=1;i<=N;i++)
            if(i!=K)
                if(minTime[i]==Integer.MAX_VALUE)   return -1;
                else
                res = Math.max(res,minTime[i]);


        return res;

    }

    public static int minSwapsCouples(int[] row) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<row.length;i++)
            map.put(row[i],i);
        int swaps = 0;
        for(int i=0;i<row.length;i+=2){
            int another = (row[i]%2==0)?row[i]+1:row[i]-1;
            int pos = map.get(another);
            if(pos!=i+1){
                //swap
                swaps++;
                map.put(row[i+1],pos);
                row[pos] = row[i+1];
            }
        }

        return swaps;
    }


}
