package Trie;

import java.util.*;

public class Trie {

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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        return search_help(root,word,0);
    }

    private boolean search_help(Node root, String word, int start){

        if(root == null) return false;
        if(start == word.length()) return root.isexist;
        char c = word.charAt(start);
        return search_help(root.links[c],word,start+1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return startsWith_help(root,prefix,0);
    }

    private boolean startsWith_help(Node root, String prefix, int start){

        if(root == null) return false;
        if(start == prefix.length()) return true;
        char c = prefix.charAt(start);
        return startsWith_help(root.links[c],prefix,start+1);
    }
}