import Tree.TreeNode;
import Tree.TreeUtil;

public class jindong {

    public static void main(String[] args){
        TreeNode tr = TreeUtil.buildTree(new Integer[]{1,2,6,3,5,null,null,4});
        try {
            TreeNode tr1 = TreeUtil.buildTreeFromLists(new int[][]{{2, 1}, {3, 2}, {4, 3}, {5, 2}, {6, 1}});
            System.out.println(stepOutOfStadium(tr));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(stepOutOfStadium(tr));
    }

    public static int stepOutOfStadium(TreeNode tr){
        return Math.max(steps(tr.left),steps(tr.right));

    }

    public static int steps(TreeNode tr){
        //preliminary
        if(tr==null)    return 0;

        int left = steps(tr.left);
        int right = steps(tr.right);
        return left+right+1;

    }

}
