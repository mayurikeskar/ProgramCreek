package ArraysAndString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileStructure {

	private static final Logger log = Logger.getLogger(FileStructure.class.getName());

	static StringBuilder path = new StringBuilder();

	static int currentSpace = -1;

	static Set<String> filePath = new HashSet<String>();

	static Deque<String> stack = new ArrayDeque<>();

	static Map<String, Integer> nameSpace1 = new HashMap<>();

	/***
	 * 
	 * Starting point of the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//String input = "dir1 \n dir11 \n dir12 \n  picture.jpeg \n dir121 \n file1.txt \ndir2 \n file2.gif ";
		String input = "dir1\n dir11\n  file.txt\n dir12\n  file2.txt\n  dir121\n   image.png\n  dir122\n   image2.jpeg\n dir13\n dir14\n  image3.png\ndir2\n dir21\n dir22\n dir23\n  image4.png";
		//String input = "dir1\ndir2\ndir3\ndir4\n dir41\n  image.txt\n  dir411\n   text.png\n   dir4111\n    image.png\n dir42\n  image.jpeg\ndir5\n dir51\n  image.png";

		String[] files = input.split("\n");

		for (String s : files) {
			performCalculation(s);
		}

		int total = 0;
		for (String finalPath: filePath) {
			//log.log(Level.INFO, finalPath);
			System.out.println(finalPath);
			total = total + finalPath.length();
		}
		System.out.println(total);
	}

	private static void performCalculation(String s) {
		int spaces = s.length() - s.replaceAll("^\\s+", "").length();

		String trimmedString = s.trim();
		if (spaces > currentSpace) {
			path.append("\\").append(trimmedString);

			if (s.indexOf('.') < 0) {
				nameSpace1.put(trimmedString, spaces);
				currentSpace = spaces;
				stack.push(trimmedString);
			} else {
				// TOUCH ME NOT
				/*
				 * path = (path.lastIndexOf('\\') >= 0) ? path.substring(0, path.lastIndexOf('\\')) : path;
				 * 
				 * String s1 = s.trim(); path = path + "\\" + s1; switch (s1.substring(s1.indexOf('.') + 1)) { case
				 * "jpeg": case "gif": case "png": filePath.put(s.trim(), path); break;
				 * 
				 * default:
				 */


				path = (path.lastIndexOf("\\") >= 0) ? 
						new StringBuilder(path.substring(0, path.lastIndexOf("\\"))) : path;

				String path1 = path + "\\" + trimmedString;
				switch (trimmedString.substring(trimmedString.indexOf('.') + 1)) {
				case "jpeg":
				case "gif":
				case "png":
					filePath.add(path1);
				}
			}
		} else if (!stack.isEmpty() && s.indexOf('.') < 0 && nameSpace1.get(stack.peek()) == spaces) {
			stack.pop();
			stack.push(trimmedString);
			path = (path.lastIndexOf("\\") >= 0) ? 
					new StringBuilder(path.substring(0, path.lastIndexOf("\\"))) : path;
			path.append("\\").append(trimmedString);
					
			nameSpace1.put(trimmedString, spaces);
		} else if (nameSpace1.get(stack.peek()) > spaces) {
			while (nameSpace1.get(stack.peek()) > spaces) {
				stack.pop();
				path = (path.lastIndexOf("\\") >= 0) ? 
						new StringBuilder(path.substring(0, path.lastIndexOf("\\"))) : path;
			}
			stack.pop();
			path = (path.lastIndexOf("\\") >= 0) ? 
					new StringBuilder(path.substring(0, path.lastIndexOf("\\"))) : path;
			path.append("\\").append(trimmedString);
			nameSpace1.put(s.trim(), spaces);
			currentSpace = spaces;
			stack.push(trimmedString);
		} else {
			switch (trimmedString.substring(trimmedString.indexOf('.') + 1)) {
			case "jpeg":
			case "gif":
			case "png":
				filePath.add(path.toString());
				break;
			default:
			}
		}

	}

}