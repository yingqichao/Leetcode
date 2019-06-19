package Tree;
import java.util.*;
public class postorder {
    public static void main(String[] args) {
        TreeNode tr =  buildTree(new int[]{1,2,4,3,5,7,6},new int[]{4,2,1,5,7,3,6});
        List<Integer> list = postorderTraversal(tr);
        for(int i:list)
            System.out.println(i);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return recur(preorder,inorder,0,inorder.length,0,inorder.length,map);

    }
    public static TreeNode recur(int[] pre,int[] in,int preLeft,int preRight,int inLeft,int inRight,Map<Integer,Integer> map){
        //preliminary
        if(preRight==preLeft || inLeft==inRight)   return null;
        int mid = map.get(pre[preLeft]);
        int leftLength = mid-inLeft;

        TreeNode root = new TreeNode(pre[preLeft]);
        root.left = recur(pre,in,preLeft+1,         preRight,inLeft,mid   ,map);
        root.right = recur(pre,in,preLeft+1+leftLength,preRight,mid+1,inRight,map);
        return root;

    }


    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root,res);

        return res;

    }

    public static void recur(TreeNode root,List<Integer> list){
        if(root == null)    return;

        recur(root.left,list);
        recur(root.right,list);
        list.add(root.val);

    }

}
