import java.util.Arrays;

/**
 * @author Qichao Ying
 * @date 2019/8/19 14:53
 * @Description DEFAULT
 */
public class closestIsland {

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{new int[]{1,0,1},new int[]{0,0,0},new int[]{1,0,1}}));
    }

    static int[][] memo;
    public static int maxDistance(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        int res = -1;
        for(int[] in:memo)  Arrays.fill(in,-1);
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                if(grid[i][j]==1)   memo[i][j] = 0;
                if(memo[i][j]>0){
                    res = Math.max(res,memo[i][j]);
                }else{


                        helper(i,j,grid);
                        if(memo[i][j]>0){
                            res = Math.max(res,memo[i][j]);
                        }

                }
            }
        }

        return (res<=0)?-1:res;
    }

    public static int helper(int row,int col,int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length)
            return Integer.MIN_VALUE;
        if(grid[row][col]==1)   return 0;
        if(memo[row][col]==Integer.MIN_VALUE)  return Integer.MIN_VALUE;
        if(memo[row][col]!=-1)  return memo[row][col];
        int dis1 = -1;int dis2 = -1;
        int dis3 = -1;int dis4 = -1;
        //mark visited
        memo[row][col] = Integer.MIN_VALUE;

        int left1 = helper(row,col-1,grid);if(left1>=0) dis1 = 1+left1;
        int left2 = helper(row,col+1,grid);if(left2>=0) dis2 = 1+left2;
        int left3 = helper(row-1,col,grid);if(left3>=0) dis3 = 1+left3;
        int left4 = helper(row+1,col,grid);if(left4>=0) dis4 = 1+left4;

        int res = Integer.MAX_VALUE;
        if(dis1>=0)    res = Math.min(res,dis1);
        if(dis2>=0)    res = Math.min(res,dis2);
        if(dis3>=0)    res = Math.min(res,dis3);
        if(dis4>=0)    res = Math.min(res,dis4);
        if(res==Integer.MAX_VALUE)  res = Integer.MIN_VALUE;
        memo[row][col] = res;
        return memo[row][col];
    }

}
