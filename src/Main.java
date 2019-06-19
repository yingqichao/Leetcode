import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] L = new int[]{0,2,4,6,8};

//        System.out.println(-Arrays.binarySearch(L,-1)-1);


        int[] L = new int[]{1,2,3,4,5,6,7,8,9,12};
//        int res = Arrays.binarySearch(L,4);
        int[] L1 = new int[]{1,3,0,0,0,0,0,0,0,0};
////        double d = 114.145;
        double d = Three(L,10);
        DecimalFormat df = new DecimalFormat("#0.000000");
        String str = df.format(d);
        System.out.println(str);
        System.out.println();
//
        System.out.println(Two(L1,2,2));
    }

    public static double Three(int[] L,int d){
        if(L.length<2)  return 0;
        Arrays.sort(L);
        double sum = 0;
        for(int i=1;i<=L.length-1;i++)  sum+=i;
        sum *=2;
        int res = 0;
        for(int sock:L){
            int left = Arrays.binarySearch(L,sock-d);
            left = (left<0)?-left-1:left;
            int right = Arrays.binarySearch(L,sock+d);
            right = (right<0)?-right-2:right;
            res += right-left;
        }
        double d1 = res/sum;
        return (double)Math.round(d1*1000000)/1000000;

    }

    public static int max = 0;
    public static int Two(int[] L,int len1,int len2){
        List<Integer> res = new LinkedList<>();
        int i=0;
        for(int num:L){
            for(int j=0;j<num;j++)  res.add(i);
            i++;
        }

        recur(res,0,0,0,0,0,len1,len2);
        return max;
    }

    public static void recur(List<Integer> list,int index,int A,int B,int Alen,int Blen,int AMaxlen,int BMaxlen){
        if(Alen==AMaxlen && Blen==BMaxlen) {
            max = Math.min(max,A*B);return;
        }

        //put it with A
        if(Alen<AMaxlen){
            int A1 = A*10+list.get(index);
            recur(list,index+1,A1,B,Alen+1,Blen,AMaxlen,BMaxlen);
        }

        //put it with B
        if(Blen<BMaxlen){
            int B1 = B*10+list.get(index);
            recur(list,
                    index+1,A,B1,Alen,Blen+1,AMaxlen,BMaxlen);
        }


    }

}
