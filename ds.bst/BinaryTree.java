package ds.bst;

import ds.list.SingleLinkedList;

/**
 * A class of a binary tree.
 */
public class BinaryTree {
    /** Head node for this tree */
    BinaryNode root;
    private int nodecount;
    // Declare more variables HERE

 	/** Constructor */
	public BinaryTree() { 
		root = null;
		nodecount=0;
		// fill your code
	}
    // Implement more constructors HERE

	/** Reinitialize tree */
	public void clear() { 
		root = null;
		nodecount=0;
		// fill your code

	}

	/** Insert a record into the tree. */
	public void insert(String name, int grade) {
		root = inserthelp(root, name, grade);
		nodecount++;
		// fill your code
	}

	/** Remove a record from the tree. */
	public int remove(String name) {	//I'm gonna return the score of student "name"
		int tempScore = findhelp(root, name);
		if(tempScore != -1) {	//What if the score is, in fact 0? findhelp should return -1 then. But let's fix it later.
			root = removehelp(root,name);
			nodecount--;
		}
		// fill your code
		return tempScore;
	}


	/** @return Record with key value k, null if none exist. */
	public int find(String name) {
		// fill your code
		return findhelp(root,name);
	}

	/** @return The number of records. */
	public int size() { 
		return nodecount;
		// fill your code
	}
	private int findhelp(BinaryNode rt, String name) {
		if(rt==null) return -1;
		if(rt.getKey().compareTo(name)>0)
			return findhelp(rt.getLeft(), name);
		else if(rt.getKey().compareTo(name)==0)
			return rt.getElement();
		else return findhelp(rt.getRight(), name);
	}

	public void inorder(SingleLinkedList list) { 
		inorderHelper(root, list);
		while(list.length()!=0) {	//added this code rn!
			list.moveToStart();
			String temp = list.remove();
			System.out.println("ORDER: "+temp+" "+find(temp));
		}
	}

	private void inorderHelper(BinaryNode rt, SingleLinkedList list){
		if(rt==null) return;
		if(rt.isLeaf()) {
			//System.out.println(rt.getKey()+" "+rt.getElement());
			list.append(rt.getKey());
		}
		// fill your code
		else {
			inorderHelper(rt.getLeft(), list);
			//System.out.println(rt.getKey()+" "+rt.getElement());
			list.append(rt.getKey());
			inorderHelper(rt.getRight(), list);
		}
	}
	
	public int rangeSearch(String from, String to) { 
		return rangeSearchHelper(root, from, to); 
	}
	
	private int rangeSearchHelper(BinaryNode rt, String from, String to){
		SingleLinkedList list = new SingleLinkedList();
		inorderHelper(rt,list);
		int posstart = 0;
		int posend = 0;
		list.moveToStart();
		while(list.currPos()!=list.length()) {
			if(list.getValue().equals(from))
				break;
			posstart += 1;
			list.moveToPos(posstart);
		}
		list.moveToStart(); // I forgot to put this and as a result, the wrong answer was printed when I did sth like range (last element) (last element) -> -값 반환.
		while(list.currPos()!=list.length()) {
			if(list.getValue().equals(to))
				break;
			posend += 1;
			list.moveToPos(posend);
		}
		// fill your code
		list = null;
		return posend-posstart+1;
	}
	
	
	/** @return The current subtree, modified to contain
 the new item */
	private BinaryNode inserthelp(BinaryNode rt, String name, int grade) {
		if(rt == null) return new BinaryNode(name,grade);
		if(rt.getKey().compareTo(name)>0)
			rt.setLeft(inserthelp(rt.getLeft(),name,grade));
		else
			rt.setRight(inserthelp(rt.getRight(),name,grade));
		return rt;
		// fill your code
	}
	
	/** Remove a node with key value k
  @return The tree with the node removed */
	private BinaryNode removehelp(BinaryNode rt, String name) {
		if(rt==null) return null;
		if(rt.getKey().compareTo(name)>0)
			rt.setLeft(removehelp(rt.getLeft(),name));
		else if(rt.getKey().compareTo(name)<0)
			rt.setRight(removehelp(rt.getRight(),name));
		else {
			if(rt.getLeft()==null)
				return rt.getRight();
			else if(rt.getRight() == null)
				return rt.getLeft();
			else {
				BinaryNode temp = getmin(rt.getRight());
				rt.setElement(temp.getElement());
				rt.setKey(temp.getKey());
				rt.setRight(deletemin(rt.getRight()));
			}
		}
		return rt;
	}
	
	public BinaryNode getmin(BinaryNode rt) {
		// fill your code
		if(rt.getLeft()==null)
			return rt;
		else
			return getmin(rt.getLeft());
	}
	
	public BinaryNode getmax(BinaryNode rt) { //I inserted this for 'last' method.
		// fill your code
		if(rt.getRight()==null)
			return rt;
		else
			return getmax(rt.getRight());	//damn it!!!! 또 여기서 getmin 소환해서 과제점수 깎였어ㅜㅜㅜ
	}
	
	private BinaryNode deletemin(BinaryNode rt) {
		if(rt.getLeft()==null)
			return rt.getRight();
		else {
			rt.setLeft(deletemin(rt.getLeft()));
			return rt;
		}
	}
	


    // Implement more functions HERE
}
