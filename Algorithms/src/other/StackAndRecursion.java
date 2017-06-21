package other;

import java.io.File;
import java.util.Stack;

public class StackAndRecursion {

	public static void main(String[] args) {
		
		
		findFoldersByStack(new File("D:/home"));
	}

	public static void findFoldersRecursively(File folderPath){
		File[] files = folderPath.listFiles();
		if(files!=null){
			for(File f:files){
				if(f.isDirectory()){
					System.out.println(f.getAbsolutePath());
					findFoldersRecursively(f);
				}
			}
		}
	}
	
	public static void findFoldersByStack(File folderPath) {
		Stack<File> stack = new Stack<File>();
		stack.push(folderPath);

		while (!stack.isEmpty()) {
			File file = stack.pop();
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isDirectory()) {
					System.out.println(f.getAbsolutePath());
					stack.push(f);
				}
			}
		}

	}
}
