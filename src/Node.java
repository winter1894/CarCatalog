import java.awt.Graphics;
import automobile.*;

/**
 * A definition of what a node is for node construction and communication with item.
 */
public class Node{

	/**The data for a particular item.
	 */
	private Automobile car;
	/**A reference to the next node in the linked list.
	 */
	private Node next;

	/**
	 * Default constructor for Node, set variables to null.
	 */
	public Node(){
		this.car=null;
		this.next=null;
	}

	/**
	 * Returns the requested data
	 */
	public Automobile getCar(){
		return car;
	}

	/**
	 * Sets the data for the node
	 */
	public void setCar(Automobile car){
		this.car=car;
		this.next=null;
	}

	/**
	 * Retrieves the next node in the linked list
	 */
	public Node getNext(){
		return next;
	}

	/**
	 * Sets where the next node is
	 */
	public void setNext(Node next){
		this.next=next;
	}

	/**
	 * Paints the items stored when called for a particular node
	 */
	public void paint(Graphics pane) {
	}
}