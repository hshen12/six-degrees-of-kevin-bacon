import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FindPath {
	private String firstName;
	private String secondName;
	private LinkedList[] list;
	private LinkedList[] firstNameList;
	private ArrayList<String> firstListNoDuplicate;
	private LinkedList[]  secondNameList;
	private ArrayList<String> secondListNoDuplicate;
	private String[] firstArray;
	private String[] secondArray;
	private String path;
	
	
	public FindPath(String firstName, String secondName, LinkedList[] list) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.list = list;
		this.firstNameList = new LinkedList[list.length];
		this.firstListNoDuplicate = new ArrayList<String>();
		this.secondNameList = new LinkedList[list.length];
		this.secondListNoDuplicate = new ArrayList<String>();
	}
	
	public int findPath() {
		//find the lines have two names and store them into two different array
		int firstIndex = 0;
		int secondIndex = 0;
		
		for(int i = 0; i < list.length; i++) {
			if(list[i].contains(firstName)) {
				firstNameList[firstIndex] = list[i];
				firstIndex++;
			}
			if(list[i].contains(secondName)) {
				secondNameList[secondIndex] = list[i];
				secondIndex++;
			}
		}
		
		//take out every name in each linkedlist and put them in an arraylist (no duplicate name, no user inputed name)
		//convert the arraylist to array
		
		for(LinkedList first: firstNameList) {
			Iterator firstIterator = first.listIterator();
			while(firstIterator.hasNext()) {
				String thisName = (String) firstIterator.next();
				if(!thisName.equalsIgnoreCase(firstName) && !firstListNoDuplicate.contains(thisName)) {
					firstListNoDuplicate.add(thisName);
				}
			}
		}
		this.firstArray = (String[]) firstListNoDuplicate.toArray();
		
		for(LinkedList second: secondNameList) {
			Iterator secondIterator = second.listIterator();
			while(secondIterator.hasNext()) {
				String thisName = (String) secondIterator.next();
				if(!thisName.equalsIgnoreCase(secondName) && !secondListNoDuplicate.contains(thisName)) {
					secondListNoDuplicate.add(thisName);
				}
			}
		}
		this.secondArray = (String[]) secondListNoDuplicate.toArray();
		
		for(String firstNameFriend: firstArray) {
			for(String secondNameFriend: secondArray) {
				if(firstNameFriend.equalsIgnoreCase(firstName) || secondNameFriend.equalsIgnoreCase(secondName)) {
					return 0;
				}
				
				if(firstNameFriend.equals(secondNameFriend)) {
					this.path = firstNameFriend;
					return 1;
				}
			}
		}
		
		return -1;
	}
	
	public String getPath() {
		return this.path;
	}
}
