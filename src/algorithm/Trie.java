package algorithm;

import java.util.HashMap;

/**
 * Created by maliu2 on 10/17/15.
 */
public class Trie {
    private char letter;
    private Trie parent = null;
    private HashMap<Character, Trie> children;
    public Trie(){}

    public void setChar(char letter){
        this.letter = letter;
    }

    public boolean hasChild(char nextLetter){
        return children.containsKey(nextLetter);
    }

    public boolean insert(char nextLetter){
        if (!this.hasChild(nextLetter)) {
            Trie temp = new Trie();
            temp.setChar(nextLetter);
            temp.parent = this;
            children.put(nextLetter, temp);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(char nextLetter){
        if(!this.hasChild(nextLetter)) return false;

        children.remove(nextLetter);
        return true;
    }

    public Trie nextLetter(char nextLetter){
        Trie result = children.get(nextLetter);
        return result;
    }

    public Trie preivousLetter(){
        return this.parent;
    }
}
