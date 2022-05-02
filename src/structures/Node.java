package structures;

public class Node {

			
	//Información
	private int value;
	private int turnos;
	
	//Enlaces
	private Node previous;
	private Node next;
	
	
	public Node(int value) {
		this.value = value;
		this.turnos=0;
	}
	
	

	public int getTurnos() {
		return turnos;
	}



	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}



	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Node getPrevious() {
		return previous;
	}


	public void setPrevious(Node previous) {
		this.previous = previous;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}

	
	
}