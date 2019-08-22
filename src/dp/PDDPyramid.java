package dp;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PDDPyramid {

    public static void main(String[] args) {
        System.out.println(buildPyramid(new int[]{1,2,3,4,5,6,7,8,9},new int[]{1,1,1,1,1,1,1,1,1,9}));
    }

    public static int buildPyramid(int[] width,int[] weight){
        Queue<int[]> q = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int maxWeight = 0;
        for(int i=0;i<width.length;i++){
            q.offer(new int[]{width[i],weight[i]});
            maxWeight = Math.max(maxWeight,weight[i]);
        }
        //1 Dimension DP
        int[] memo = new int[maxWeight*7+1];
//        Arrays.fill(memo,-1);
        while(q.size()!=0){
            int[] res = q.poll();int w = res[1];
            memo[w*7] = Math.max(memo[w*7],1);
            for(int i=memo.length-1;i>=0;i--){
                if(memo[i]!=0 && i>=w){
                    memo[Math.min(i-w,w*7)] = Math.max(memo[Math.min(i-w,w*7)],memo[i]+1);
                }
            }

        }
        int max = 0;
        for(int i=0;i<memo.length;i++)  max = Math.max(max,memo[i]);

        return max;


        // 2 dimension DP
//        int[][] memo = new int[width.length][maxWeight+1];
//        memo
//        for(int i=memo.length-1;i>=0;i--){
//            for(int j=maxWeight;j>=0;j--){
//                if(memo[i][j]>0)
//
//            }
//
//
//        }


//
//        return 0;

    }


}
