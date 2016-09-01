package PrefixTrie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	
	private char c;
	private boolean isLeaf;
	private Map<Character, TrieNode> childern = new HashMap<Character, TrieNode>();

	public TrieNode(){
	}
	
	public TrieNode(char c){
		this.c = c;
	}
	
	public char getC() {
		return c;
	}


	public void setC(char c) {
		this.c = c;
	}


	public Map<Character, TrieNode> getChildern() {
		return childern;
	}


	public void setChildern(Map<Character, TrieNode> childern) {
		this.childern = childern;
	}


	public boolean isLeaf() {
		return isLeaf;
	}


	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}
