package Tree;
import java.util.*;
public class TreeUtil {

    public static TreeNode buildTree(Integer[] list){
        return recur(list,0);
    }

    public static TreeNode recur(Integer[] list,int index){
        if(index>=list.length || list[index]==null)  return null;
        TreeNode tr = new TreeNode(list[index]);
        TreeNode left = recur(list,2*index+1);
        TreeNode right = recur(list,2*index+2);
        tr.left = left;tr.right = right;
        return tr;
    }

    public static TreeNode buildTreeFromLists(int[][] lists) throws Exception{
        Map<Integer,TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(1);
        map.put(1,root);
        for(int[] relation:lists){
            //假设后面出现的是父节点，前面出现的是子节点，
            //                      1         1
            //                    /             \
            // 也就是 2 1 表示   2      或者       2
            TreeNode tr = map.getOrDefault(relation[1],new TreeNode(relation[1]));
            TreeNode newTree = new TreeNode(relation[0]);
            if(tr.left==null){
                tr.left = newTree;
            }else if(tr.right==null){
                tr.right = newTree;
            }else
                throw new Exception("题目错了！左右节点都满了！不做了！");
            map.put(relation[0],newTree);

        }

        return root;

    }


    public static MultiTreeNode buildMultiTreeFromLists(int[] lists,int[] color){
        Map<Integer,MultiTreeNode> map = new HashMap<>();
        MultiTreeNode root = new MultiTreeNode(0);
        root.color = color[0];
        map.put(0,root);
        for(int i=0;i<lists.length;i++){
            MultiTreeNode tr = map.getOrDefault(lists[i],new MultiTreeNode(lists[i]));

            MultiTreeNode newTree = new MultiTreeNode(i+1);
            newTree.color=color[i+1];
            if(tr.child==null)  tr.child = new LinkedList<>();
            tr.child.add(newTree);
            map.put(i+1,newTree);
        }

        return root;
    }
}
