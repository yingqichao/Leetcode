package Tree;

public class TreeNode {
    public int val;
    public  TreeNode left;
    public  TreeNode right;
    public  TreeNode(int x) { val = x; }

    @Override
    public int hashCode() {
        return val;
    }
}