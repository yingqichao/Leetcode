import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public class Tencent {

    public static void main(String[] args) {
//        int[] w1 = new int[]{8,5,10};int[] w2 = new int[]{1,2,4,8};
//        int[] g1 = new int[]{1,1,2};int[]g2 = new int[]{1,2,1,2};
//
//
//        System.out.println(Three(w1,g1));
//        System.out.println(Three(w2,g2));
        int[] mianzhi = new int[]{1,2,5,10,20,50};
//       System.out.println(One(100,mianzhi));

    }

    public static int Three(int[] wuli,int[] gold){

        return backtrack(wuli,gold,0,0);
    }

    public static int backtrack(int[] wuli,int[] gold,int index,int had){
        if(index>=wuli.length)  return 0;
        int one = Integer.MAX_VALUE;int two = Integer.MAX_VALUE;
        //bribe the monster
        one = gold[index]+backtrack(wuli,gold,index+1,had+wuli[index]);

        //do not bribe
        if(had>wuli[index])
            two = backtrack(wuli,gold,index+1,had);

        return Math.min(one,two);

    }

//    public static int One(int target,int[] mianzhi){
//        if(mianzhi.length==0)   return -1;
//        Arrays.sort(mianzhi);
//        if(mianzhi[0]!=1)   return -1;
//        int max = 0;
//
//        int[][] money = new int[target][mianzhi.length];
//        for(int[] m:money)
//            Arrays.fill(m,-1);
//        for(int m:mianzhi){
//            if(m-1<target)  money[m-1][target]=1;
//        }
//
//        for(int i=0;i<target;i++){
//            if(money[i][target]!=-1){
//                max = Math.max(max,money[i][target]);
//                for(int m:mianzhi){
//                    if(i+m<target){
//                        if(money[i+m]==-1)  money[i+m]=money[i]+1;
//                        else    money[i+m] = Math.min(money[i+m],money[i]+1);
//                    }
//                }
//            }
//
//        }
//
//        return max;
//    }

//    public static int One(int target,int[] mianzhi){
//
//        Arrays.sort(mianzhi);int sum = 0;
//        int rest = target;
//        sum+=rest/mianzhi[mianzhi.length-1];
//
//        for(int i=mianzhi.length-2;i>0;i--){
//            rest = mianzhi[i+1]-1;
//            sum+=rest/mianzhi[i];
//        }
//
//        return sum;
//    }

}
