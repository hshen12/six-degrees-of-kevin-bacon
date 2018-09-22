import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * GraphBuilder
 * @author Hao Shen
 *
 */
public class GraphBuilder {
	
	private AdjacencyList list;
	private File inputFile;
	private LinkedList[] listArr;;
	
	/**
	 * constructor
	 * @param filename
	 */
	public GraphBuilder(String filename) {
		this.list = new AdjacencyList();
		this.inputFile = new File(filename);

	}
	
	/**
	 * getter method
	 * @return LinkedList[]
	 */
	public LinkedList[] getList() {
		return listArr;
	}
	
	/**
	 * buildGraph method
	 * read line by line and seperate names out
	 * @throws Exception
	 */
	public void buildGraph() throws Exception{

		try(Scanner input = new Scanner(inputFile)) {
			input.nextLine();
			int lineNum = 0;

			while(input.hasNextLine()) {
				
				String nextLine = input.nextLine();
				int begin = nextLine.indexOf("[");
				int end = nextLine.indexOf("]");
				String cast = nextLine.substring(begin, end+1);
				if(cast != "[]") {
					String spl[] = cast.split("\"\"name\"\"");

					for(int i = 1; i < spl.length; i++) {
						int lastName = spl[i].indexOf(",")-2;

						String peopleName = spl[i].substring(4, lastName);
						list.add(peopleName, lineNum);
					}
					list.incrementSize();
					lineNum++;
				}
			}
			this.listArr = list.getLinkedList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
