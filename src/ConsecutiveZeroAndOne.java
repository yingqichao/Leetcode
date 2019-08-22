/**
 * @author Qichao Ying
 * @date 2019/8/6 14:47
 * @Description DEFAULT
 */
public class ConsecutiveZeroAndOne {

    public static void main(String[] args) {
           System.out.println(findMaxLength(new int[]{0,1,1,0,1,0,1,0,1,1,0,0}));
    }

    public static int findMaxLength(int[] nums) {
        int max = 0;
        int[][] dp = new int[nums.length][nums.length];
        //出现0就-1，出现1就加1

        for(int i=0;i<nums.length;i++){
            dp[i][i] = (nums[i]==1)?dp[i][i]+1:dp[i][i]-1;
            //update
            for(int j=0;j<i;j++){
                dp[j][i] = (nums[i]==1)?dp[j][i-1]+1:dp[j][i-1]-1;
                if(dp[j][i]==0) max = Math.max(i-j+1,max);
            }
        }

        return max;
    }
}
