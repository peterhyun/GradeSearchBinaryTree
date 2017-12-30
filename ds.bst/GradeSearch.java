package ds.bst;

import ds.list.SingleLinkedList;

public class GradeSearch {
	private BinaryTree bst;
	
	
	public GradeSearch(){
		bst = new BinaryTree();
		// fill your code
	}
	
    // Implement more constructors HERE
	
	public void add(String name, int grade){
		bst.insert(name, grade);
		System.out.println("ADD: "+name+" "+grade);
		// fill your code

	}
	
	public int remove(String name){
		// fill your code
		int temp = bst.remove(name);
		if(temp==-1) {
			System.out.println("GradeSearch cannot find the student.");
		}
		else {
			System.out.println("REMOVE: "+name);
		}
		return temp;
	}
	
	public int get(String name){ //get the score
		int temp = bst.find(name);                           
		// fill your code          
		if(temp==-1) {
			System.out.println("GradeSearch cannot find the student.");
		}
		else {
			System.out.println("GET: "+name+" "+temp);
		}
		return temp;                  
	}                              
	                               
	public int size(){             
		                           
		// fill your code          
                                   
		return bst.size();                  
	}                              
	                               
	public void order(){
		SingleLinkedList temporary = new SingleLinkedList();
		// fill your code
		bst.inorder(temporary);
	}
	
	public String first(){
		if(bst.size()==0) {
			System.out.println("GradeSearch does not have any student.");
			return null;
		}
		BinaryNode temp = bst.getmin(bst.root);
		return temp.getKey()+" "+temp.getElement();
		// fill your code
	}
	
	public String last(){
		if(bst.size()==0) {
			System.out.println("GradeSearch does not have any student.");
			return null;
		}
		BinaryNode temp = bst.getmax(bst.root);
		// fill your code
		return temp.getKey()+" "+temp.getElement();
	}
	
	public int range(String from, String to){
		// fill your code
		if(bst.find(from)==-1) {
			System.out.println("The range is wrong");
			return 0;
		}
		if(bst.find(to)==-1) {
			System.out.println("The range is wrong");
			return 0;
		}
		return bst.rangeSearch(from, to);
	}
	
    // Implement more functions HERE

}