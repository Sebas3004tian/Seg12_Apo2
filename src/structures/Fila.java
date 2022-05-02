package structures;

public class Fila {
	private Node head;
	private Node turno;
	
	public Fila(){
		head=null;
		turno=null;
	}
	
	
	
	public Node getTurno() {
		return turno;
	}



	public void setTurno(Node turno) {
		this.turno = turno;
	}



	public Node getHead() {
		return head;
	}


	public void setHead(Node head) {
		this.head = head;
	}
	
	public void eliminacionAutomatica(){
		if(turno!=null) {
			if(turno.getTurnos()==3) {
				System.out.println("El turno "+turno.getValue()+" sera eliminado debido a que fue saltado 3 veces.");
				deleteTurno();
			}
		}
	}
	
	public void pasarTurno(){
		
		Node nodeAux=turno.getNext();
		if(nodeAux!=null && nodeAux!=turno) {
			turno.setTurnos(turno.getTurnos()+1);
			setTurno(nodeAux);
		}else {
			System.out.println("No quedan mas personas en la fila a las cuales pasar turno.");
		}
		
	}

	public int size() {
		return size(head,0);
	}
	private int size(Node current,int n) {

		if(head == null) {
			return 0;
		} 
		n++;
		if(head.getPrevious()==null) {
			return 1;
		}
		if(current.equals(head.getPrevious())) {
			return n;
		}
		return size(current.getNext(),n);
	}
	
	public void addFirst(Node node) {
		if(head == null) {
			head = node;
		}
		else {
			node.setNext(head);
			head.setPrevious(node);
			head = node;
		}
	}
	
	public void addLast(Node node) {
		if(head==null) {
				head = node;
				turno=node;
		}else if(size()==1) {
			head.setPrevious(node);
			node.setNext(head);
			head.setNext(node);
			node.setPrevious(head);
		}
		else if(size()>1){
			node.setPrevious(head.getPrevious());
			head.getPrevious().setNext(node);
			node.setNext(head);
			head.setPrevious(node);
		}else {
			head = node;
			turno=node;
		}
	}
	
	public Node search(int goal) {
		return search(head, goal);
	}
	
	private Node search(Node current, int goal) {

	
		if(current.getValue() == goal) {
			return current;
		} 
		
		if(current.equals(head.getPrevious())) {
			return null;
			
		}
		
		return search(current.getNext(),goal);

	}
	
	public void print() {
		print(head);
	}
	
	private void print(Node current) {
		if(current==null) {
			return;
		}

		System.out.print(current.getValue()+"("+current.getTurnos()+"), ");	
		
		if(!current.equals(head.getPrevious())) {
			print(current.getNext());
		}
	}
	public void deleteTurno() {
		deleteTurno(head);
	}
	
	public void deleteTurno(Node current) {
		int size=size();
		if(size==0) {
			System.out.println("No hay personas para eliminar de la fila.");
			return;
		}
		if(size==1) {
			current=null;
			head=null;
			turno=null;
			return;
		}
		if(current == null) {
			return;
		}
		
		if(current.getPrevious()==null && current==turno) {
			head = current.getNext();
			return;
		}
		if(current.getNext()==null && current==turno) {
			head.setPrevious(current.getPrevious());
			return;
		}
		if(current==turno) { 
			//current.getPrevious().setNext(current.getNext());
			//current.getNext().setPrevious(current.getPrevious());
			Node ant=current.getPrevious();
			Node sig=current.getNext();
			if(current==head) {
				setHead(sig);
			}
			if(ant==sig) {
				ant.setNext(null);
				ant.setPrevious(null);
			}else {
				ant.setNext(sig);
				sig.setPrevious(ant);
			}
			setTurno(sig);
		
			return;
		}
		if(!current.equals(head.getPrevious())) {
			System.out.println("6.");
			deleteTurno(current.getNext());
		}
	}
	public void delete(int value) {
		delete(head, value);
	}
	
	public void delete(Node current, int value) {
		if(current == null) {
			return;
		}
		
		if(current.getPrevious()==null && current.getValue()==value) {
			head = current.getNext();
			return;
		}
		if(current.getNext()==null && current.getValue()==value) {
			head.setPrevious(current.getPrevious());
			return;
		}
		if(current.getValue()==value) {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
			return;
		}
		if(!current.equals(head.getPrevious())) {
			delete(current.getNext(),value);
		}
	}
	
	
}
