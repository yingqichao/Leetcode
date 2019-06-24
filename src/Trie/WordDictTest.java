package Trie;

public class WordDictTest {
    public static void main(String[] args) {

        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));// -> false
        System.out.println(wd.search("bad"));// -> true
        System.out.println(wd.search(".ad"));// -> true
        System.out.println(wd.search("b.."));// -> true



    }

}
