package PrefixTrie_better;

public class Trie_Operations {
	
	public Node root;
	
	public Trie_Operations(){
		root = new Node();
	}

	public void insert(String word){
		
		Node node = root;
		char characs[] = word.toCharArray();
		for(int i =0; i<characs.length; i++){
			if(node.containsKey(characs[i])){
				node = node.get(characs[i]);
			}else{
				Node n = new Node();
				n.data = characs[i];
				node.put(characs[i], n);
				node = node.get(characs[i]);
			}
		}
		node.isChild = true;
	}
	
	public boolean isPresent(String word){
		
		Node node = root;
		
		char[] characs = word.toCharArray();
		for(char ch : characs){
			if(!node.containsKey(ch))
				return false;
			node = node.get(ch);
		}
		if(node.isChild)
			return true;
		else
			return false;
		
	}
}
