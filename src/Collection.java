import java.awt.Graphics;

import automobile.*;

/**
 * 
 * @author Matthew
 *
 *Storage of cars for presentation in GUI
 */
public class Collection {

	/**retains the location of the head node
	 */
	private Node head;
	/**keeps track of size of linked list.
	 */
	private int size=0;
	/**keeps track of the currently selected object
	 * (May or may not actually end up being used)
	 */
	private int selected=-1;

	/**
	 * Default constructor, allows a new collection to exist.
	 */
	public Collection(){
		head=new Node();
	}

	/**
	 * returns the size of the linked list
	 */
	public int getSize(){
		//returns size of linked list
		return size;
	}

	/**
	 * By default, the reset method resets the selected item to the beginning
	 *		of the collection.
	 */
	public void reset() {
		//selected goes back to first
		selected=0;
	}

	/**
	 * Resets the list of objects 
	 */
	public void reset(Automobile automobile){

		//nothing currently selected
		selected=-1;

		//reset node initially set to first node.
		Node reset=head.getNext();
		//loop through locating specified object
		for (int i=0; selected==-1 && i<size; i++){
			if(reset.getCar() == automobile){
				selected=i;
			}
			//the current node is set to the specified object taken in
			reset = reset.getNext();
		}
	}

	/**
	 * Adds the given Item to the collection.
	 *	That item becomes the item currently selected.
	 */
	public void add(Automobile automobile) {

		//New node is created for every additional item
		Node placeHolder=new Node();

		//Stores information
		placeHolder.setCar(automobile);
		//Sets a link to the next Node
		placeHolder.setNext(head.getNext());
		head.setNext(placeHolder);

		//increment number of nodes up
		size++;
	}

	/**
	 * The only "graphical" method of the class is the paint method.
	 */
	public void paint(Graphics pane) {

		//a paint node to use as a reference when painting linked list
		Node currentPaint;
		currentPaint=head;

		//Goes through all non-null nodes, painting each individually
		while (currentPaint.getNext()!=null){
			currentPaint=currentPaint.getNext();
			currentPaint.paint(pane);
		}
	}

	/**
	 * Determines whether the selected item is
	 *		followed by another item.
	 */
	public boolean hasNext() {
		//returns whether there is another object next or not
		return (size > 0) && (selected >= 0) && (selected < size);
	}

	/**
	 * 	Returns the currently selected item and sets
	 *		the following item as the selected item
	 *		(if any item is currently selected).
	 */
	public Object next() {

		//next node for storing next node's location
		Node next=head.getNext();
		//if size is exceeded, next object does not exist.
		if (selected>=size){
			return null;
		}

		//if there are objects in the linked list, proceed to finding next
		if ((size > 0) && (selected >= 0) && (selected < size)){
			//relative to head.getNext(), find requested next
			for(int i=0; i<selected; i++){
				next=next.getNext();
			}
			//the selected is incremented up by one
			selected=selected+1;
		}
		//return next
		return next.getCar();
	}

	/**
	 * Removes the selected item (if any).
	 */
	public void remove() {

		//placeholders for the next and previous nodes relative to the selected node.
		Node headNext=head;
		Node headPrev=null;

		//moves and removes highlighted
		if ((selected >= 0) && (selected < size)) {
			for (int i = 0 ; i < selected+1; i++){
				headPrev=headNext;
				headNext=headNext.getNext();
			}
			//removes the object highlighted			
			headPrev.setNext(headNext.getNext());

			//adjust size
			size--;
			//confirm no current selection after removal
			selected=-1;
		}
	}
}