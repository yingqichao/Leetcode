import java.util.*;

/**
 * @author Qichao Ying
 * @date 2019/8/5 12:09
 * @Description DEFAULT
 */
public class DecodeString {
    static TreeSet<Integer> left = new TreeSet<>();static TreeSet<Integer> right = new TreeSet<>();
    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
        findOcurrences("we will we will rock you","we","will");
    }


    public static String decodeString(String s) {

        Token token = dfs(s,0);
        return token.str;
    }

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList();
        String[] texts = text.split(" ");
        int size = texts.length;

        for(int i=0;i< size ;i++){
            if(texts[i].equals(first) && texts[i+1].equals(second)){
                list.add(texts[i+2]);
            }
        }

        String[] result = new String[list.size()];
        for(int i=0;i< list.size();i++){
            result[i] = list.get(i);
        }

        return result;
    }

    public static Token dfs(String s,int startingIndex){
        //boundary issue
        StringBuilder str = new StringBuilder();
        if(startingIndex>=s.length())   return new Token(0,"");
        int pointer = startingIndex;
        int repeat = 1;
        while(pointer<s.length() && s.charAt(pointer)!=']') {
            if(s.charAt(pointer) <= 'z' && s.charAt(pointer) >= 'a'){
                for(int i=0;i<repeat;i++)   str.append(s.charAt(pointer));
                repeat = 1;
            }
            else if(s.charAt(pointer) <= 'Z' && s.charAt(pointer) >= 'A'){
                for(int i=0;i<repeat;i++)   str.append(s.charAt(pointer));
                repeat = 1;
            }
            else if (s.charAt(pointer) <= '9' && s.charAt(pointer) >= '0') {
                int begin = pointer;
                while (s.charAt(pointer) <= '9' && s.charAt(pointer) >= '0') pointer++;

                repeat = Integer.parseInt(s.substring(begin, pointer));
                pointer--;
            }
            else if(s.charAt(pointer)=='['){
                //start recursion
                Token token = dfs(s,pointer+1);
                pointer = token.pointer;
                for(int i=0;i<repeat;i++)   str.append(token.str);
                repeat = 1;
            }

            pointer++;
        }

        return new Token(pointer,str.toString());


    }

    static class Token {
        int pointer = 0;
        String str;

        public Token(int p,String str){
            this.pointer = p;
            this.str = str;
        }

    }

}
