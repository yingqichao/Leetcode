package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qichao Ying
 * @date 2019/7/30 11:14
 * @Description DEFAULT
 */
public class giveTwoTraversalOutputTheThird {
    public static void main(String[] args) {

    }

    public static TreeNode givePreorderAndInorder(int[] preorder, int[] inorder) {
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

    public static TreeNode giveInorderAndPostorder(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return recur1(postorder,inorder,0,inorder.length,0,inorder.length,map);
    }

    public static TreeNode recur1(int[] post,int[] in,int preLeft,int preRight,int inLeft,int inRight,Map<Integer,Integer> map){
        //preliminary
        if(preRight==preLeft || inLeft==inRight)   return null;
        int mid = map.get(post[preRight-1]);
        int leftLength = mid-inLeft;

        TreeNode root = new TreeNode(post[preRight-1]);
        root.left = recur1(post,in,preLeft,preLeft+leftLength    ,inLeft,mid   ,map);
        root.right = recur1(post,in,preLeft+leftLength,preRight-1,mid+1,inRight,map);
        return root;

    }

}
