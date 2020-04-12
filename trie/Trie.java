package ivanmarkovic.trie_leetcode;
/*
208. Implement Trie (Prefix Tree)
Medium

https://leetcode.com/problems/implement-trie-prefix-tree/

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.

Accepted
253,793
Submissions
567,954
*/
public class Trie {

    class TrieNode {
    
        TrieNode parent;
        Character key;
        HashMap<Character, TrieNode> children;
        boolean terminating;
        
        public TrieNode(Character key, TrieNode parent) {
            this.key = key;
            this.parent = parent;
            this.children = new HashMap<Character, TrieNode>();
        }

        public TrieNode(){
            this.children = new HashMap<Character, TrieNode>();
        }
    }
	
	TrieNode root;
	/** Initialize your data structure here. */
	public Trie() {
		this.root = new TrieNode();
	}
	
	 /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode current = this.root;
        for(char c: word.toCharArray()) {
        	if(!current.children.containsKey(c)) {
        		current.children.put(c, new TrieNode(c, current));
        	}
        	current = current.children.get(c);
        }
        current.terminating = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode current = this.root;
        for(char c: word.toCharArray()) {
        	if(!current.children.containsKey(c)) {
        		current = null;
        		break;
        	}
        	current = current.children.get(c);
        }
        if(current == null)
        	return false;
        else
        	return current.terminating;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode current = this.root;
        for(char c: prefix.toCharArray()) {
        	if(!current.children.containsKey(c)) {
        		current = null;
        		break;
        	}
        	current = current.children.get(c);
        }
        if(current == null)
        	return false;
        return true;
    }

}
