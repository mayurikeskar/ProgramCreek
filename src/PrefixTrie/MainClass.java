package PrefixTrie;

public class MainClass {

	public static void main(String[] args) {
		
		TrieOperations to = new TrieOperations();
		
		to.insert("cat");
		to.insert("card");
		to.insert("balloon");
		
		
		System.out.println(to.isPresent("balloon"));
		
	}
}
