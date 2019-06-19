import Tree.MultiTreeNode;
import Tree.TreeUtil;

public class meituan {

    public static long time = 0;

    public static void main(String[] args){
        MultiTreeNode tr = TreeUtil.buildMultiTreeFromLists(
                new int[]{0,0},
                new int[]{1,0,0});

        System.out.println(times(tr));
    }

    public static int times(MultiTreeNode tr){
        int[] res = recur(tr);
        return res[1];
    }

    public static int[] recur(MultiTreeNode tr){
        //return time of: 0个1，1个1
        if(tr==null)    return new int[]{0,0};
        if(tr.child==null)  return (tr.color==0)?new int[]{1,0}:new int[]{1,1};
        int[] ones = new int[tr.child.size()];int[] zeros = new int[tr.child.size()];
        for(int i=0;i<tr.child.size();i++){
            int[] tmp = recur(tr.child.get(0));
            zeros[i] = tmp[0];ones[i] = tmp[1];
        }
        long totalZero = 1; long totalOne = 1;long allZeros = 1;
        for(int i=0;i<tr.child.size();i++){
            totalZero*=zeros[i];
            long tmp = 1;
            for(int j=0;j<tr.child.size();j++){
                if(j==i)    continue;
                tmp*=zeros[j];
            }
            totalOne+=tmp*ones[i];
        }

        totalOne = totalOne%(1000000007);totalZero = totalZero%(1000000007);allZeros = allZeros%(1000000007);

        if(tr.color==0) return new int[]{(int)totalZero,(int)totalOne};
        else    return new int[]{(int)totalZero,(int)totalZero};

    }


}
