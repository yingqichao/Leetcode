import java.util.LinkedList;
import java.util.List;

public class xiecheng {
    public static void main(String[] args) {


        System.out.println(xc("3 /A/B/C /A/B/C/D /A/B/C/D"));

    }

    public static String xc(String str){

        String[] strs = str.split(" ");String[] out = new String[strs.length-1];String result = new String();
        Trie tr = new Trie();
        for(int i=1;i<strs.length;i++){
            String res = strs[i];
            if(res.startsWith("/")) {
                res = res.substring(1, res.length());
            }
            if(res.endsWith("/")) {
                res = res.substring(0, res.length() - 1);
            }
            String[] strin = res.split("/");
            out[i-1] = tr.insert(strin);
        }

        for(String st:out){
            result = result+st;
            result = result+" ";
        }

        return result.trim();


    }
}

class Trie {
    class TrieNode {
        List<TrieNode> children;
        String word;
        int time;

        TrieNode(String str) {
            children = new LinkedList<>();
            time = 0;
            word = str;
        }
    }

    TrieNode root;


    public Trie() {
        root = new TrieNode("");
    }


    public String insert(String[] str) {
        List<Integer> list = new LinkedList<>();
        String res = "";
        boolean same = true;
        TrieNode temp = root;TrieNode addtemp = root;boolean notfound = true;
        for (int i = 0; i < str.length; i++) {
            notfound = true;
            for (TrieNode tr : temp.children) {
                if (tr.word.equals(str[i])) {
//                    if (temp != root) tr.time++;
                    list.add(tr.time);
                    notfound = false;
                    temp = tr;
                    break;
                }
            }
            if (notfound) {
                same = false;
                list.add(1);
                TrieNode newtr = new TrieNode(str[i]);
//                newtr.time = 1;
                temp.children.add(newtr);
                temp = newtr;
            }
        }
        //add
        if(!notfound) {
            list.clear();
            for (int i = 0; i < str.length; i++) {

                for (TrieNode tr : addtemp.children) {
                    if (tr.word.equals(str[i])) {
                        if (addtemp != root) tr.time = (tr.time==0)?2:tr.time+1;
                        list.add(tr.time);
//                        list.add(tr.time);
                        addtemp = tr;
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || i == list.size() - 1) res = res + "1";
            else res = res + ((same) ? list.get(i) : 1);
        }
        return res;
    }
}

//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TrieNode temp = root;
//        for(int i = 0; i < word.length(); i++) {
//            if(temp.children[word.charAt(i)-'a'] == null)
//                return false;
//            temp = temp.children[word.charAt(i)-'a'];
//        }
//        return temp.isWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TrieNode temp = root;
//        for(int i = 0; i < prefix.length(); i++) {
//            if(temp.children[prefix.charAt(i)-'a'] == null)
//                return false;
//            temp = temp.children[prefix.charAt(i)-'a'];
//        }
//        return true;
//    }
//}
