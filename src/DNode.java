
public class DNode {
	
	//Create privatate instance variables
	
	private Object element; //will be used for indexing?
	private DNode prev; //will be used for previous node
	private DNode next; //will be used for next node
	
	//Create DNode Constructor, assign instance variables
	public DNode (Object element, DNode prev, DNode next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	//create the getElement method, type Object
	public Object getElement() {
		return element; //return the element
	}
	
	//create the getPrev method, type DNode
	public DNode getPrev() {
		return prev; //return previous node
	}
	
	//create the getNext method, type DNode
	public DNode getNext() {
		return next;
	}
	
	//create the setElement method, type void
	public void setElement (Object element) {
		this.element = element;
	}
	
	//create the setPrev method, type void
	public void setPrev (DNode prev) {
		this.prev = prev;
		}
	
	//create the setNext method, type void
	public void setNext (DNode next) {
		this.next = next;
	}

}
