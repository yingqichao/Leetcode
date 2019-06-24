package Trie;
import java.util.*;
class ReplaceWord {
    public static void main(String[] args) {





    }

    public static String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>(dict);
        Trie trie = new Trie();
        for(String str:set) trie.insert(str);

        StringBuilder str = new StringBuilder();
        for(String s:sentence.split(" ")){
            str.append(trie.startsWith(s));
            str.append(" ");
        }

        return str.toString().trim();



    }

    public static class Trie {

        private Node root;
        private static final int R = 128;
        /** Initialize your data structure here. */
        public Trie() {

            root = new Node();
        }

        private class Node{

            boolean isexist;
            Node[] links;
            public Node(){

                isexist = false;
                links = new Node[R];
            }
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            insert_help(root,word,0);
        }

        private Node insert_help(Node root, String word, int start){

            if(root == null) root = new Node();
            if(start == word.length()){

                root.isexist = true;
                return root;
            }
            char c = word.charAt(start);
            root.links[c] = insert_help(root.links[c],word,start+1);
            return root;
        }


        /** Returns if there is any word in the trie that starts with the given prefix. */
        public String startsWith(String prefix) {
            StringBuilder str = new StringBuilder();
            return startsWith_help(str,root,prefix,0);
        }

        private String startsWith_help(StringBuilder str,Node root, String prefix, int start){

            if(root == null) return prefix;
            if(start == prefix.length()) return str.toString();
            str.append(prefix.charAt(start));
            char c = prefix.charAt(start);
            return startsWith_help(str,root.links[c],prefix,start+1);
        }
    }

}
