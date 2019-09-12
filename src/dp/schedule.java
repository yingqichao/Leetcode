package dp;

/**
 * @author Qichao Ying
 * @date 2019/8/24 10:23
 * @Description DEFAULT
 */
public class schedule {

    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{new int[]{10,20},new int[]{30,200},new int[]{400,50},new int[]{30,20}}));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int N = costs.length;
        int[] dp = new int[N+1];//Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<N;i++){
            int[] revise = new int[dp.length];
            for(int j=0;j<dp.length-1;j++){
                revise[j+1] = (dp[j+1]==0)?(dp[j]+costs[i][0]):Math.min(dp[j+1],dp[j]+costs[i][0]);
                if(i+1-j<=N/2)
                    //place in 1
                    revise[j] += costs[i][1];

            }

            for(int k=0;k<revise.length;k++){
                if(revise[k]!=0)    dp[k] = revise[k];
            }

        }
        return dp[dp.length-1];
    }
}
