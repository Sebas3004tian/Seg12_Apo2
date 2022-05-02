package main;

import java.util.Scanner;

import structures.Fila;
import structures.Node;

public class Main {
	Scanner sc=new Scanner(System.in);
    Fila fila=new Fila();
    
    private int turnosTotal=0;

    public static void main(String[] args) {
        Main inicio = new Main();
        inicio.inicio();
    }
    public void inicio() {
    	fila.eliminacionAutomatica();
    	mostrar();
    	System.out.println("");
    	System.out.println("Menu fila Bancolombia: \n");
    	System.out.println("1. Dar turno\r\n"
    			+ "2. Mostrar turno\r\n"
    			+ "3. Pasar turno\r\n"
    			+ "4. Eliminar turno actual\r\n"
    			+ "");
    	int respuestaMenu=sc.nextInt();
    	switch(respuestaMenu) {
    	case 1:
    		añadirLista();
    		 inicio();
    		break;
    	case 2:
    		mostrarTurno();
    		 inicio();
    		break;
    	case 3:
    		pasarTurno();
    		 inicio();
    		break;
    	case 4:
    		eliminarTurno();
    		 inicio();
    		break;
    	case 5:
    		mostrar();
    		inicio();
    		break;
    	}
    }
    public void añadirLista() {
    	Node turno=new Node(turnosTotal+1);
		fila.addLast(turno);
		turnosTotal+=1;
    }
    public void mostrarTurno(){
    	if(fila.getTurno()==null) {
    		System.out.println("No hay personas con turno en estos momentos.");
    	}else {
        	int turno=fila.getTurno().getValue();
        	System.out.println("El turno es :"+turno);
    	}
    }
    public void pasarTurno(){
    	fila.pasarTurno();
    }
    public void eliminarTurno() {
    	fila.deleteTurno();
    }
    public void mostrar() {
    	fila.print();
    }
}
