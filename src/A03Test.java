import java.util.LinkedList;
import java.util.Scanner;

public class A03Test {

	/**
	 * main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		if(args.length < 1) {
			System.out.println("useage: java assignmentTest <csv file directory>");
			System.exit(0);
		}
		
		String filePath = System.getProperty("user.dir") + "\\";
		String[] arr = args[0].split("/");
		for(String st: arr) {
			filePath += st;
			filePath += "\\";
		}
		
		filePath = filePath.substring(0, filePath.length()-1);
		
		GraphBuilder builder = new GraphBuilder(filePath);
		builder.buildGraph();
		
		LinkedList[] list = builder.getList();
		
		System.out.println("actor 1 name:");
		String firstName = getName(list);
		System.out.println("actor 2 name:");
		String secondName = getName(list);
		
		FindPath finder = new FindPath(firstName, secondName, list);
		
		int flag = finder.findPath();
		
		if(flag == -1) {
			System.out.println("there is no path between two actors");
		} else if(flag == 1) {
			String path = finder.getPath();
			System.out.printf("path between two actors is %s --> %s --> %s.\n", firstName, path, secondName);
		} else {
			System.out.printf("path between two actors is %s --> %s.\n", firstName, secondName);
		}
		
	}

/**
 * getName method
 * as for input and check the name with the list for existing
 * @param list
 * @return String
 * @throws Exception
 */
	private static String getName(LinkedList[] list) throws Exception{
		
		String name = "";
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		
		while(flag == false) {
			
			name = sc.next();
			for(LinkedList l: list) {
//				System.out.println(l.getFirst());
				if(l.contains(name)) {
					flag  = true;
					continue;
				}
			}	
			System.out.println("no such actor");
		}
		sc.close();
		return name;
	}
}
