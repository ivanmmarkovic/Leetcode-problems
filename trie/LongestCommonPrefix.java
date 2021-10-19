package trie;

import java.util.HashMap;

/*
14. Longest Common Prefix
Easy

https://leetcode.com/problems/longest-common-prefix/

Runtime: 7 ms, faster than 22.04% of Java online submissions for Longest Common Prefix.
Memory Usage: 39.4 MB, less than 11.23% of Java online submissions for Longest Common Prefix.

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lower-case English letters.

Accepted
1,243,881
Submissions
3,275,619

*/
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		TriePrefix trie = new TriePrefix();
		for (String word : strs) {
			if (word.equals("")) // ["","b"] -> returhns ""
				return "";
			trie.insert(word);
		}

		return prefix(trie);
	}

	private String prefix(TriePrefix trie) {
		return helper(trie.root);
	}

	private String helper(TrieNode root) {
		StringBuilder sb = new StringBuilder();
		sb.append("");
		while (true) {
			if (root.key != null)
				sb.append(root.key);
			if (root.terminating) // ["ab", "a"] -> "a", get shortest word
				break;
			if (root.children.size() != 1)
				break;
			for (Character c : root.children.keySet()) {
				root = root.children.get(c);
				break;
			}
		}
		return sb.toString();

	}

}

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

	public TrieNode() {
		this.children = new HashMap<Character, TrieNode>();
	}
}

class TriePrefix {

	TrieNode root;

	/** Initialize your data structure here. */
	public TriePrefix() {
		this.root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode current = this.root;
		for (char c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				current.children.put(c, new TrieNode(c, current));
			}
			current = current.children.get(c);
		}
		current.terminating = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode current = this.root;
		for (char c : word.toCharArray()) {
			if (!current.children.containsKey(c)) {
				current = null;
				break;
			}
			current = current.children.get(c);
		}
		if (current == null)
			return false;
		else
			return current.terminating;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode current = this.root;
		for (char c : prefix.toCharArray()) {
			if (!current.children.containsKey(c)) {
				current = null;
				break;
			}
			current = current.children.get(c);
		}
		if (current == null)
			return false;
		return true;
	}
}
