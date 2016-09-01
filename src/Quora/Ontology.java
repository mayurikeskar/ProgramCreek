package Quora;
import java.util.*;


class Topic{

	String name;
	List<Topic> childern;
	
	public Topic(String name){
		this.name = name;
		childern = new ArrayList<Topic>();
	}

	public String toString(){
		return name;
	}
}

public class Ontology {

    Topic root;
	Map<String, List<String>> mapOfQuestions = new HashMap<String, List<String>>();

	public Ontology(){
		root = null;
	}

	public void insertTopic(String str){

		String[] topics = str.split(" ");
		Stack<Topic> stack = new Stack<Topic>();

		if(root == null){
			root = new Topic(topics[0]);
			stack.push(root);
		}

		Topic parent = null;
		for(int i=1; i<topics.length; i++){

			if(topics[i].equals("(")){
				String temp = topics[i-1];
				stack.push(parent);
				parent = new Topic(temp);
			} else if(topics[i].equals(")"))
				parent = stack.pop();
			else{
				insert_helper(root, parent, topics[i]);
			}

		}
	}

	public void insert_helper(Topic root, Topic parent, String child){
		if(parent == null)
			return;

		if(root.name.equals(parent.name)){
			Topic t = new Topic(child);
			root.childern.add(t);
			return;
		} else{
			for(Topic topic : root.childern){
				insert_helper(topic, parent, child);
			}
		}
	}

	public void insertQuestion(Topic root, String topic, String question){
		//		if(root == null)
		//			return;
		//
		//		if(root.name.equals(topic)){
		//			root.questions.add(question);
		//			return;
		//		} 
		//
		//		for(Topic t : root.childern){
		//			insertQuestion(t, topic, question);
		//		}
		List<String> li;
		if(mapOfQuestions.containsKey(topic))
			li = mapOfQuestions.get(topic);
		else
			li = new ArrayList<String>();

		li.add(question);
		mapOfQuestions.put(topic, li);
	}


	public int search(String topic, String query){
		return search_helper(root, topic, query, 0);
	}

	public int search_helper(Topic root, String topic, String prefix, int count){
		if(root == null)
			return count;

		if(root.name.equals(topic))
			count = getCount(root, prefix, count);
		else{
			for(Topic t : root.childern){
				count = count + search_helper(t, topic, prefix, 0);
			}
		}
		return count;
	}

	public int getCount(Topic root, String prefix, int count){

		if(root == null)
			return count;

		if(mapOfQuestions.containsKey(root.name)){
			for(String s : mapOfQuestions.get(root.name)){
				if(s.startsWith(prefix))
					count++;
			}
		}

		for(Topic t : root.childern){
			count = count + getCount(t, prefix, 0);
		}

		return count;
	}

    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Ontology sol = new Ontology();
        sol.insertTopic(s);
        
        int q = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<q; i++){
            String str = sc.nextLine();
            String[] split = str.split(":");
            sol.insertQuestion(sol.root, split[0], split[1].trim());
        }
        
        int query = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<query; i++){
            String str = sc.nextLine();
            String[] split = str.split(" ", 2);
            
            System.out.println(sol.search(split[0], split[1].trim()));
        }
    }
}