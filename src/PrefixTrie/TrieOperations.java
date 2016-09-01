package PrefixTrie;

import java.util.Map;

public class TrieOperations {
	
	public TrieNode root;
	
	public TrieOperations(){
		root = new TrieNode();
	}

	public void insert(String word){
	
		Map<Character, TrieNode> childern = root.getChildern();
		for(int i =0; i<word.length(); i++){
			char ch = word.charAt(i);
			
			TrieNode t;
			if(childern.containsKey(ch)){
				t = childern.get(ch);
			} else{
				t = new TrieNode(ch);
				childern.put(ch, t);
			}
			childern = t.getChildern();
			
			if(i == word.length() -1){
				t.setLeaf(true);
			}
		}
	}
	
	public boolean isPresent(String word){
		Map<Character, TrieNode> childern = root.getChildern();
		
		for(int i =0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode t;
			if(childern.containsKey(ch)){
				if(i == word.length()-1){
					t = childern.get(ch);
					if(t.isLeaf())
						return true;
				}	
				childern = childern.get(ch).getChildern();
			}
			else return false;
		}
		return false;
	}
	
}
