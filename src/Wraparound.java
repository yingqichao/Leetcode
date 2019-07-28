public class Wraparound {
    //如果我们求得以每个字母开头的子串，然后再将它们加起来，就可以得到所有的子串

    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("zab"));
    }

    public static int[][] memo = new int[26][26];

    public static int findSubstringInWraproundString(String p) {
        if(p.length()==0)   return 0;
        int sum = 0;char pre = 'z';int begin = 0;
        for(int i=0;i<p.length();i++){
            if(i!=0){
                if(p.charAt(i)==pre+1 || (p.charAt(i)=='a'&&pre=='z')){
                    // runlength++;
                }else{
                    sum += sum(begin,i,p);
                    begin = i;
                }
            }

            pre = p.charAt(i);
        }

        sum+=sum(begin,p.length(),p);


        return sum;
    }

    public static int sum(int begin,int end,String p){
        int s = 0;
        for(int i=begin;i<end;i++){
            for(int j=i;j<end;j++){
                if(memo[p.charAt(i)-'a'][p.charAt(j)-'a']==0){
                    s++;
                    memo[p.charAt(i)-'a'][p.charAt(j)-'a'] = 1;
                }

            }
        }
        return s;

    }

}
