/**
 * @author Qichao Ying
 * @date 2019/8/19 16:26
 * @Description DEFAULT
 */
public class repeatedString {
    public static void main(String[] args) {
        System.out.print(maxRepOpt1("bbababaaaa"));
    }
    public static int maxRepOpt1(String text) {
        int[] num = new int[26];
        for(char c:text.toCharArray()){
            num[c-'a']++;
        }
        int[] memo = new int[text.length()];
        int count = 0;int res = 0;boolean canShift = true;
        for(int i=0;i<text.length();i++){
            if(i==0){
                count++;
            }
            else if(text.charAt(i)!=text.charAt(i-1)){
                //和前一个不一样
                if(i==1){
                    continue;
                }else if(text.charAt(i)==text.charAt(i-2)){
                    //和前前一样
                    if(canShift && num[text.charAt(i)-'a']>=count+2){
                        count=memo[i-2]+2;canShift = false;
                    }else{
                        //断掉
//                        res = Math.max(res,count);
                        count = 1;canShift = true;
                    }
                }else{
                    //和前前不一样
                    //断掉
                    res = Math.max(res,memo[i-2]+((memo[i-2]<num[text.charAt(i-2)-'a'])?1:0));
                    count = 1;canShift = true;
                }
            }else{
                if(i!=1)
                    res = Math.max(res,memo[i-2]+((memo[i-2]<num[text.charAt(i-2)-'a'])?1:0));

                count++;
            }
            count = Math.min(count,num[text.charAt(i)-'a']);
            memo[i] = count;
            res = Math.max(res,count);


        }
        if(text.charAt(text.length()-1)!=text.charAt(text.length()-2) &&
                num[text.charAt(text.length()-1)-'a']>=count+1)
            res++;
        res = Math.max(res,count);
        return res;

    }
}
