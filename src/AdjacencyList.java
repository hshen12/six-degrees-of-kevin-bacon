import java.util.LinkedList;

/**
 * AdjacencyList class
 * @author Hao Shen
 *
 */
public class AdjacencyList {
	private LinkedList[] list;
	private int size;
	
	/**
	 * constructor
	 */
	public AdjacencyList() {
		list = new LinkedList[5000];
		for(int i = 0; i < list.length; i++) {
			list[i] = new LinkedList();
		}
	}
	
	/**
	 * add method 
	 * add the name to the list
	 * @param name
	 * @param index
	 */
	public void add(String name, int index) {
		if(index >= size) { 
			growList();
		}

		list[index].add(name);
	}

	/**
	 * incrementSize method
	 * increment size
	 */
	public void incrementSize() {
		size++;
	}
	
	/**
	 * growList method
	 * grow the list when there is not enough slots
	 */
	private void growList() {
		LinkedList[] newList = new LinkedList[list.length+50];
		System.arraycopy(list, 0, newList, 0, list.length);
		for(int i = list.length; i < newList.length; i++) {
			newList[i] = new LinkedList();
		}
		this.list = newList;
	}
	
/**
 * getter method
 * @return LinkedList[]
 */
	public LinkedList[] getLinkedList() {
		return this.list;
	}
	
}
