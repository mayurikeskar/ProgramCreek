package PrefixTrie_better;

public class Node {
	
	public char data;
	public Node[] childern;
	public boolean isChild;
	
	public Node(){
		childern = new Node[26];
	}
	
	public boolean containsKey(char ch){
		return childern[ch - 'a'] != null;
	}
	
	public void put(char ch, Node node){
		childern[ch - 'a'] = node;
	}
	
	public Node get(char ch){
		return childern[ch - 'a'];
	}

}
