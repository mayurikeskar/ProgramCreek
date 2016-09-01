package PrefixTrie_better;

public class MainClass {

	public static void main(String[] args) {
		
		Trie_Operations to = new Trie_Operations();
		
		to.insert("cat");
		to.insert("card");
		to.insert("balloon");
		
		
		System.out.println(to.isPresent("balloon"));
	}
}
