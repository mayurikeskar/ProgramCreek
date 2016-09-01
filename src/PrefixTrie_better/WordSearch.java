package PrefixTrie_better;

class Node1 {

	public char data;
	public Node1[] childern;
	public boolean isVisited;

	public Node1(){
		childern = new Node1[26];
	}

	public boolean containsKey(char ch){
		return childern[ch - 'a'] != null;
	}

	public void put(char ch, Node1 node){
		childern[ch - 'a'] = node;
	}

	public Node1 get(char ch){
		return childern[ch - 'a'];
	}
	
	public String toString(){
		return ""+data;
	}

}

class Operations{

	Node1 root;

	public Operations(){
		root = new Node1();
	}

	public void insert(char[][] dict){

		Node1 node = root;
		Node1 n;
		char letters[] = new char[dict.length*dict.length];

		int k = 0;
		for(int i =0; i<dict.length; i++){
			for(int j =0; j<dict[i].length; j++){
				letters[k] = dict[i][j];
				k++;
				if(!node.containsKey(dict[i][j])){
					n = new Node1();
					n.data = dict[i][j];
					node.put(dict[i][j], n);
				}
			}
		}

		int len = dict.length;
		for(int i =0; i<letters.length; i++){
			Node1 temp = node.get(letters[i]);

			if(i+1 < (len*len) && (i+1)%len != 0){
				Node1 child1 = new Node1();
				child1.data = letters[i+1];
				temp.put(letters[i+1], child1);
			}

			if(i-1 >= 0 && i%len != 0){
				Node1 child1 = new Node1();
				child1.data = letters[i-1];
				temp.put(letters[i-1], child1);
			}
			
			if((i-len) >= 0){
				Node1 child1 = new Node1();
				child1.data = letters[i-len];
				temp.put(letters[i-len], child1);
			}
			
			if((i+len) < len*len){
				Node1 child1 = new Node1();
				child1.data = letters[i+len];
				temp.put(letters[i+len], child1);
			}
			
		}
	}
	
	public boolean isPresent(String word){
		
		Node1 node = root;
		char[] val = word.toCharArray();
		for(int i =0; i<word.length(); i++){
			char ch = val[i];
			if(node.containsKey(ch) && node.get(ch).isVisited == false){
				node.get(ch).isVisited = true;
				if(i == word.length()-1){
					for(Node1 n : root.childern){
						if(n != null)
							n.isVisited = false;
					}
					return true;
				}
				if(!node.get(ch).containsKey(val[i+1]))
						return false;
			}
			else
				return false;
		}
		return true;
		
		
		
	}
}
public class WordSearch {

	public static void main(String[] args) {
		
		Operations o = new Operations();
		char[][] dict = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		o.insert(dict);
	//	System.out.println(o.isPresent("oath"));
	//	System.out.println(o.isPresent("eat"));
		System.out.println(o.isPresent("rain"));
	}

}
