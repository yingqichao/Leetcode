import Tree.TreeNode;

import java.util.*;

public class minCostTickets {

    public static void main(String[] args) {
//        int[] days = new int[]{1,4,6,7,8,20};
//        int[] costs = new int[]{7,2,15};
//        System.out.println(mincostTickets(days,costs));

        int[][] res = new int[][]{new int[]{0,0,0,0},new int[]{1,0,1,0},new int[]{0,1,1,0},new int[]{0,0,0,0}};

        System.out.println(numEnclaves(res));

    }


    public static int mincostTickets(int[] days, int[] costs) {
        //Tickets:1,7,30
        int[] memo = new int[days[days.length-1]];
        Set<Integer> set = new HashSet<>();
        for(int day:days)   set.add(day-1);

        for(int i=0;i<memo.length;i++){
            if(!set.contains(i)){
                //does not need to travel
                if(i!=0)    memo[i] = memo[i-1];
            }else{
                //need to travel
                memo[i] = ((i==0)?0:memo[i-1]) + costs[0];
                memo[i] = Math.min(memo[i],((i-7>=0)?memo[i-7]:0)+costs[1]);
                memo[i] = Math.min(memo[i],((i-30>=0)?memo[i-30]:0)+costs[2]);

            }
        }

        return memo[memo.length-1];
    }

    public static int numEnclaves(int[][] A) {
        for(int i=0;i<A.length;i++){
            dfs(A,i,0);dfs(A,i,A[0].length-1);
        }
        for(int i=0;i<A[0].length;i++){
            dfs(A,0,i);dfs(A,A.length-1,i);
        }
        int count = 0;
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++)
                if(A[i][j]==1)  count++;

        return count;
    }

    public static void dfs(int[][] A,int row,int col){
        if(row>=A.length||row<0||col>=A[0].length||col<0)  return;

        if(A[row][col]==1)
        {
            A[row][col] = 0;
            dfs(A,row+1,col);dfs(A,row-1,col);dfs(A,row,col+1);dfs(A,row,col-1);
        }


    }


//    public List<TreeNode> generateTrees(int n) {
//        List<Integer> list = new LinkedList<>();
//        for(int i=1;i<=n;i++)   list.add(i);
//
//
//    }

//    public TreeNode construct(List<Integer> leftlist){
//        TreeNode tr = new TreeNode(0);List<Integer> rightlist = new LinkedList<>();
//        for(int i=0;i<leftlist.size();i++){
//            int tmp = leftlist.get(i);
//            tr.val  = tmp;
//            leftlist.remove(i);
//            for(int j=0;j<leftlist.size();j++){
//
//            }
//
//
//            leftlist.add(i,tmp);
//        }
//
//
//    }

}
