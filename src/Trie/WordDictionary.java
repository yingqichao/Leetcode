package Trie;

class WordDictionary {

    private Node root;
    private static final int R = 128;

    /** Initialize your data structure here. */
    public WordDictionary() {
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

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search_help(root,word,0);
    }

    private boolean search_help(Node root, String word, int start){

        if(root == null) return false;
        if(start == word.length()) return root.isexist;
        char c = word.charAt(start);
        if(c=='.'){
            for(int i=0;i<R;i++)
                if(search_help(root.links[i],word,start+1))   return true;
            return false;
        }
        else    return search_help(root.links[c],word,start+1);

//        return search_help(root.links[c],word,start+1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return startsWith_help(root,prefix,0);
    }

    private boolean startsWith_help(Node root, String prefix, int start){

        if(root == null) return false;
        if(start == prefix.length()) return true;
        char c = prefix.charAt(start);
        if(c=='.'){
            for(int i=0;i<R;i++)
                if(startsWith_help(root.links[i],prefix,start+1))   return true;
            return false;
        }
        else    return startsWith_help(root.links[c],prefix,start+1);
    }
}
