import java.util.Arrays;
import java.util.*;

public class zhaohang {
    public static void main(String[] args) {
//        int[] res = Two(3,new int[]{3,2});
//        for(int i:res)
//        System.out.println(i);
//        System.out.println(Three(new int[]{1,2,2}));
//        System.out.println(Three(new int[]{3,5,6}));
//        System.out.println(Three(new int[]{16,8,4,8}));
        System.out.println(rabbit(3));
        System.out.println(rabbit(2));
        System.out.println(rabbit(5));
        System.out.println(rabbit(6));
    }

    public static int rabbit(int month){
//        if(month<3) return 2;
        int[] memo = new int[month+1];memo[0] = 2;
        for(int i=1;i<=month;i++)
            memo[i] = memo[i-1]+((i>=3)?memo[i-3]:0);
        return memo[month];
    }

    public static int[] Two(int m,int[] sit){
        int max = Integer.MIN_VALUE;int len = sit.length;int countZeros = 0;
        //find num of zeros and max;
        for(int s:sit){
            if(s==0)    countZeros++;
            max = Math.max(max,s);
        }
        int more = m-countZeros;int remain = more;
        for(int s:sit){
            if(remain<=0)   break;
            if(s==0)    continue;
            else    remain-=(max-s);

        }

        return new int[]{(remain<=0)?max:max+(int)Math.ceil(remain/(double)len),max+more};
    }

    public static int Three(int[] in){
        if(in.length<=1)    return 0;
        int maxCommon = in[0];int res = 0;int localMax = in[0];Map<Integer,Integer> map = new HashMap<>();
        map.put(in[0],1);
        for(int i=1;i<in.length;i++){
            map.put(in[i],map.getOrDefault(in[i],0)+1);
            localMax = Math.max(localMax,in[i]);
            maxCommon = findCommon(maxCommon,in[i]);
//            if(maxCommon==1)
//                break;
        }
        if(maxCommon==1) {
            for (int i : map.keySet()) {
                int num = map.get(i);
                while (i != maxCommon) {
                    res+=num;
                    i /= 2;
                }
            }
        }else{
            int level = localMax;res = Integer.MAX_VALUE;
            while(level>=maxCommon){
                int localres = 0;
                for (int i : map.keySet()) {
                    int num = map.get(i);
                    while (i != level) {
                        localres+=num;
                        if(i>level) i /= 2;
                        else    i*=2;
                    }
                }
                res = Math.min(res,localres);
                level/=2;
            }

        }

        return res;

    }

    public static int findCommon(int a,int b){
        int max = Math.max(a,b);int min = Math.min(a,b);
        while(max>min){
            max /=2;
        }
        return (max==min)?min:1;
    }

}
