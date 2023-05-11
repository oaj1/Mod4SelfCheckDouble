
public class DList {

	// doubly linked list has header and trailer (has to be null)
	// signly linked list has head and tail (should NOT be null)
	// create instance variables
	private DNode header; // left node (no element though)
	private DNode trailer; // right node (no element)

	// create DList Constructor
	public DList() {
		header = new DNode(null, null, null);
		trailer = new DNode(null, header, null); // trailer points to header initially
		header.setNext(trailer); // Node Header points to trailer in the beginning (trailer takes value of next
									// from constuctor in the DNode Class)
	}

	// create getHeader, type DNode
	public DNode getHeader() {
		return header;
	}

	// create getTrailer method, type DNode
	public DNode getTrailer() {
		return trailer;
	}

	// create setHeader method, type void
	public void setHeader(DNode header) {
		this.header = header;
	}

	// create setTrailer method, type void
	public void setTraier(DNode trailer) {
		this.trailer = trailer;
	}

	// print method to print results
	public void print() {
		DNode current = header.getNext();
		/**
		 * if (current.getNext() == trailer) { System.out.println("No nodes"); }
		 **/
		while (current != trailer) { // why trailer and not null? Because structure is different, for single-list can
										// be null, for double, there will always be header and trailer

			System.out.println(current.getElement() + " ");
			// increment
			current = current.getNext();

		}

		System.out.println("----------------------");
	}

	// create addFirst method, type void
	public void addFirst(DNode n) { // add node n after header
		/**
		 * 
		 * before addFirst:
		 * 
		 * 
		 * header <-> temp <-> ...
		 * 
		 * 
		 * after addFirst:
		 * 
		 * header <-> n <-> temp
		 * 
		 **/
		DNode temp = header.getNext();
		header.setNext(n);
		n.setPrev(header);

		n.setNext(temp);
		temp.setPrev(n);
	}

	public void addLast(DNode n) { // add node n before trailer

		/**
		 * 
		 * before addLast:
		 * 
		 * 
		 * <-> temp <-> trailer
		 * 
		 * 
		 * after addLast:
		 * 
		 * temp <-> n <-> trailer
		 * 
		 **/
		DNode temp = trailer.getPrev(); // trailer takes on whatever came before trailer
		temp.setNext(n); // assign temp to n
		n.setPrev(temp); // put temp before n
		n.setNext(trailer); // put trailer after n
		trailer.setPrev(n);// put n before trailer

	}

	// create remove method
	public void remove(DNode n) { // remove node n
		DNode prev = n.getPrev(); // prev gets previous node before n
		DNode next = n.getNext(); // next gets next node after n

		if (prev != null && next != null) {// if there are nodes to remove
			prev.setNext(next); // we are setting the previous node, to the next node
			next.setPrev(prev);// setting the next node, to whatever the previous was
			n.setPrev(null); // node n is now pointing to next and previous node, so make it null
			n.setNext(null); // node n is now pointing to next and previous node, so make it null
		}

	}

	public void reverse() { // reverse the Doubly LinkedList
		DNode before = null; //initially a null
		DNode current = header; //initially header, which is null
		DNode after = header.getNext(); //after is the first node after header
		while (after.getNext() != null) { //while there are nodes to add
			DNode temp = after.getNext(); //temp will be whatever comes after after
			current.setPrev(after);//current is set to previous node
			current.setNext(before);  //set the next node to whatever before was
			before = current; 
			current = after;
			after = temp;
		}
		current.setPrev(after);
		current.setNext(before);
		after.setPrev(null);
		after.setNext(current);
		trailer = header;
		header = after;
	}

	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DNode a = new DNode(1, null, null);
		DNode b = new DNode(2, null, null);
		DNode c = new DNode(3, null, null);
		DList d = new DList();
		d.print();
		d.addFirst(b);
		d.addFirst(a);
		d.addLast(c);
		d.print();
		d.remove(b);
		d.print();

		d.remove(a);
		d.print();
		d.remove(c);
		d.print();
		d.addFirst(b);
		// d.print();
		d.addFirst(a);
		// d.print();
		d.addLast(c);
		d.print();

		d.reverse();
		d.print();

	}

}
