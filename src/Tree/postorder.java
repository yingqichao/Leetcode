package Tree;
import java.util.*;
public class postorder {
    public static void main(String[] args) {
        TreeNode tr =  buildTree(new int[]{10,5,2,7,15,12,20},new int[]{2,5,7,10,12,15,20});
        TreeNode newRoot = inplace(tr);
        while (newRoot!=null){
            System.out.print(newRoot.val+"<->");
            newRoot = newRoot.right;
        }


//        List<Integer> list = postorderTraversal(tr);
//        for(int i:list)
//            System.out.println(i);
    }

    public static TreeNode inplace(TreeNode root ){
        //1.leftmost node in the left part becomes the new root
        //2.rightmost node's next(right) in the left part is root
        //3.root's right is leftmost node in the right part.
        TreeNode[] res = helper(root);
        return res[0];

    }

    public static TreeNode[] helper(TreeNode root){
        //return:[leftmost node] [rightmost node]
        TreeNode leftmost = root;TreeNode rightMost = root;

        TreeNode[] left_trs = new TreeNode[0];TreeNode[] right_trs = new TreeNode[0];
        if(root.left!=null) {
            left_trs = helper(root.left);
            leftmost = left_trs[0];
            TreeNode rightMostInTheLeft = left_trs[1];
            //conduct 2
            rightMostInTheLeft.right = root;
            root.left = rightMostInTheLeft;
        }

        if(root.right!=null){
            right_trs = helper(root.right);
            //conduct 3
            TreeNode leftMostInTheRight = right_trs[0];
            root.right = leftMostInTheRight;
            leftMostInTheRight.left = root;
            rightMost = right_trs[1];
        }



        return new TreeNode[]{leftmost,rightMost};
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
