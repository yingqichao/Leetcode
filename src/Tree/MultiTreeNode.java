package Tree;

import java.util.List;

public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> child;
    public  MultiTreeNode(int x) { val = x; }
    public int color;
    @Override
    public int hashCode() {
        return val;
    }
}